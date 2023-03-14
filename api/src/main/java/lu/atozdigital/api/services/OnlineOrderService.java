package lu.atozdigital.api.services;

import lu.atozdigital.api.dtos.OnlineOrderDTO;

import java.util.List;

public interface OnlineOrderService {
    OnlineOrderDTO createOnlineOrder(OnlineOrderDTO onlineOrderDTO);

    OnlineOrderDTO updateOnlineOrder(Integer id, OnlineOrderDTO onlineOrderDTO);

    List<OnlineOrderDTO> getAllOnlineOrders();
}
