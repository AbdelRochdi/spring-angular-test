package lu.atozdigital.api.services;

import lu.atozdigital.api.dtos.OnlineOrderDTO;
import lu.atozdigital.api.shared.exceptions.ServerException;

import java.util.List;

public interface OnlineOrderService {
    OnlineOrderDTO createOnlineOrder(OnlineOrderDTO onlineOrderDTO, Integer accountId) throws ServerException;

    OnlineOrderDTO updateOnlineOrder(Integer id, OnlineOrderDTO onlineOrderDTO, Integer accountId) throws ServerException;

    List<OnlineOrderDTO> getAllOnlineOrdersByAccount(Integer accountId);
}
