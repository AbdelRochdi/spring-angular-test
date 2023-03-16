package lu.atozdigital.api.controllers;

import lu.atozdigital.api.dtos.OnlineOrderDTO;
import lu.atozdigital.api.services.OnlineOrderService;
import lu.atozdigital.api.shared.exceptions.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/online-orders")
public class OnlineOrderController {

    @Autowired
    private OnlineOrderService onlineOrderService;

    @CrossOrigin
    @PostMapping
    public ResponseEntity<OnlineOrderDTO> createOnlineOrder(@RequestBody OnlineOrderDTO onlineOrderDTO) throws ServerException {
        OnlineOrderDTO onlineOrder = onlineOrderService.createOnlineOrder(onlineOrderDTO);

        return new ResponseEntity<>(onlineOrder, HttpStatus.CREATED);
    }

    @CrossOrigin
    @PutMapping("/{id}")
    public ResponseEntity<OnlineOrderDTO> updateOnlineOrderByUuid(@PathVariable(name = "id") Integer id,
                                                                   @RequestBody OnlineOrderDTO onlineOrderDTO) throws ServerException {
        OnlineOrderDTO onlineOrder = onlineOrderService.updateOnlineOrder(id, onlineOrderDTO);

        return new ResponseEntity<>(onlineOrder, HttpStatus.OK);
    }

    @CrossOrigin
    @GetMapping
    public ResponseEntity<List<OnlineOrderDTO>> getAllOnlineOrders(){
        List<OnlineOrderDTO> onlineOrders = onlineOrderService.getAllOnlineOrders();

        return new ResponseEntity<>(onlineOrders, HttpStatus.OK);
    }

}
