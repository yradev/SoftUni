package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.Picture.ExportDTO.PictureWithSpecificSizeDTO;
import softuni.exam.instagraphlite.models.Picture.ImportDTO.PictureImportDTO;
import softuni.exam.instagraphlite.models.Picture.Picture;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.service.ValidatingService;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Collectors;

import static softuni.exam.instagraphlite.util.Paths.*;
import static softuni.exam.instagraphlite.util.Messages.*;

@Service
public class PictureServiceIMPL implements PictureService {
    private final PictureRepository pictureRepository;
    private final ValidatingService validatingService;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public PictureServiceIMPL(PictureRepository pictureRepository, ValidatingService validatingService, Gson gson, ModelMapper modelMapper) {
        this.pictureRepository = pictureRepository;
        this.validatingService = validatingService;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count()>0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(PICTURES_DATA);
    }

    @Override
    public String importPictures() throws IOException {
        return Arrays.stream(gson.fromJson(Files.readString(PICTURES_DATA),PictureImportDTO[].class))
                .map(this::saveValidRecordsToMysql)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String exportPictures() {
        return pictureRepository.findPicturesBySizeGreaterThanOrderBySizeAsc(30000).stream()
                .map(a->modelMapper.map(a, PictureWithSpecificSizeDTO.class))
                .map(PictureWithSpecificSizeDTO::toString)
                .collect(Collectors.joining());
    }

    private String saveValidRecordsToMysql(PictureImportDTO pictureImportDTO){
        if(!validatingService.ValidatePicture(pictureImportDTO)){
            return String.format(INVALID_DATA_IMPORT,"Picture");
        }

        if(pictureRepository.findPictureByPath(pictureImportDTO.getPath())!=null){
            return String.format(INVALID_DATA_IMPORT,"Picture");
        }

        pictureRepository.save(modelMapper.map(pictureImportDTO, Picture.class));

        return String.format(SUCCESSFULLY_PICTURE_IMPORT,pictureImportDTO.getSize());
    }
}
