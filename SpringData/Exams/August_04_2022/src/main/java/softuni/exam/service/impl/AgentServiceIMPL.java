package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.agent.AgentImportDTO;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.AgentRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.AgentService;
import softuni.exam.util.DtoValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.stream.Collectors;

import static softuni.exam.util.Paths.AGENTS_DATA;

@Service
public class AgentServiceIMPL implements AgentService {
    private final AgentRepository agentRepository;
    private final TownRepository townRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;

    @Autowired
    public AgentServiceIMPL(AgentRepository agentRepository, TownRepository townRepository, Gson gson, ModelMapper modelMapper) {
        this.agentRepository = agentRepository;
        this.townRepository = townRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
    }

    @Override
    public boolean areImported() {
        return agentRepository.count()>0;
    }

    @Override
    public String readAgentsFromFile() throws IOException {
        return Files.readString(AGENTS_DATA);
    }

    @Override
    public String importAgents() throws IOException {
        return Arrays.stream(gson.fromJson(Files.readString(AGENTS_DATA),AgentImportDTO[].class))
                .map(this::importValidRecordToDB)
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public String importValidRecordToDB(AgentImportDTO agentImportDTO){
        if(!DtoValidator.validate(agentImportDTO)){
            return "Invalid agent";
        }

        if(agentRepository.findAgentByFirstName(agentImportDTO.getFirstName())!=null){
            return "Invalid agent";
        }

        Town town = townRepository.findTownByTownName(agentImportDTO.getTown());

        Agent agent =  modelMapper.map(agentImportDTO,Agent.class);
        agent.setTown(town);

        agentRepository.save(agent);

        return String.format("Successfully imported agent %s %s",agentImportDTO.getFirstName(),agentImportDTO.getLastName());
    }
}
