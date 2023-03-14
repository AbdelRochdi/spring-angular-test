package lu.atozdigital.api.services.impl;

import jakarta.persistence.EntityNotFoundException;
import lu.atozdigital.api.dtos.OnlineOrderDTO;
import lu.atozdigital.api.models.OnlineOrder;
import lu.atozdigital.api.repositories.OnlineOrderRepository;
import lu.atozdigital.api.services.OnlineOrderService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

@Service
public class OnlineOrderServiceImpl implements OnlineOrderService {

    private static final Logger LOGGER = Logger.getLogger(OnlineOrderServiceImpl.class.getName());

    @Autowired
    private OnlineOrderRepository onlineOrderRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public OnlineOrderDTO createOnlineOrder(OnlineOrderDTO onlineOrderDTO){
        OnlineOrder onlineOrder = modelMapper.map(onlineOrderDTO, OnlineOrder.class);
        onlineOrder.setReference(UUID.randomUUID().toString()
                .replace("-", "")
                .substring(0, 10).toUpperCase(Locale.ROOT));

        return modelMapper.map(onlineOrderRepository.save(onlineOrder), OnlineOrderDTO.class);
    }

    @Override
    public OnlineOrderDTO updateOnlineOrder(Integer id, OnlineOrderDTO onlineOrderDTO){
        OnlineOrder onlineOrder = onlineOrderRepository.findById(id).orElseThrow(() -> {
            LOGGER.log(Level.SEVERE, "no onlineOrder found with id [{0}]", id);
            return new EntityNotFoundException("Failed to fetch onlineOrder");
        });
        modelMapper.map(onlineOrderDTO, onlineOrder);
        onlineOrderRepository.save(onlineOrder);

        return modelMapper.map(onlineOrder, OnlineOrderDTO.class);
    }

    @Override
    public List<OnlineOrderDTO> getAllOnlineOrders(){
        return onlineOrderRepository.findAll()
                .stream()
                .map(onlineOrder -> modelMapper.map(onlineOrder, OnlineOrderDTO.class))
                .toList();
    }
}
