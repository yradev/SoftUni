package source.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import source.model.dto.ShipAddDTO;
import source.model.dto.ShipViewDTO;
import source.model.entity.Ship;
import source.repository.CategoryRepository;
import source.repository.ShipRepository;
import source.repository.UserRepository;
import source.service.ShipService;
import source.session.CurrentSession;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipServiceIMPL implements ShipService {
    private final ShipRepository shipRepository;
    private final ModelMapper modelMapper;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final CurrentSession currentSession;

    public ShipServiceIMPL(ShipRepository shipRepository, ModelMapper modelMapper, CategoryRepository categoryRepository, UserRepository userRepository, CurrentSession currentSession) {
        this.shipRepository = shipRepository;
        this.modelMapper = modelMapper;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.currentSession = currentSession;
    }

    @Override
    public boolean add(ShipAddDTO shipAddDTO) {
        if(shipRepository.findByName(shipAddDTO.getName())!=null){
            return false;
        }
        shipAddDTO.setCategory(categoryRepository.findByName(shipAddDTO.getEnumCategory()));
        shipAddDTO.setUser(userRepository.findByUsername(currentSession.getUsername()));
        shipRepository.save(modelMapper.map(shipAddDTO, Ship.class));
        return true;
    }

    @Override
    public List<ShipViewDTO> getShips(boolean areOwned) {
        if(!areOwned){ return shipRepository.findAll().stream()
                    .filter(ship -> !ship.getUser().getUsername().equals(currentSession.getUsername()))
                    .map(ship -> modelMapper.map(ship, ShipViewDTO.class)).collect(Collectors.toList());
        }

        return shipRepository.findAll().stream()
                .filter(ship -> ship.getUser().getUsername().equals(currentSession.getUsername()))
                .map(ship -> modelMapper.map(ship, ShipViewDTO.class)).collect(Collectors.toList());
    }

    @Override
    public void fight(String attackerName, String defenderName) {
        Ship attacker = shipRepository.findByName(attackerName);
        Ship defender = shipRepository.findByName(defenderName);

        if(attacker == null || defender == null || attacker.getHealth()<defender.getHealth()){
            return;
        }

       defender.setHealth(defender.getHealth()-attacker.getPower());

        if(defender.getHealth()<=0){
            shipRepository.delete(defender);
            return;
        }

        shipRepository.saveAndFlush(defender);
    }
}
