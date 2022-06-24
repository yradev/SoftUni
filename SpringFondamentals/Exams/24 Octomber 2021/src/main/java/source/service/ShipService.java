package source.service;

import source.model.dto.ShipAddDTO;
import source.model.dto.ShipViewDTO;

import java.util.List;

public interface ShipService {
    boolean add(ShipAddDTO shipAddDTO);
    List<ShipViewDTO>getShips(boolean areOwned);
    void fight(String attackerName, String defenderName);
}
