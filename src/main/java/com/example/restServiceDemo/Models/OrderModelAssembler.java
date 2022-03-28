package com.example.restServiceDemo.Models;

import com.example.restServiceDemo.Controllers.OrdersController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Order,EntityModel<Order>> {
    @Override
    public EntityModel<Order> toModel(Order order) {
        EntityModel<Order> orderModel = EntityModel.of(order,
                linkTo(methodOn(OrdersController.class).one(order.getId())).withSelfRel(),
                linkTo(methodOn(OrdersController.class).all()).withRel("orders"));

        // Conditional links based on state of the order

        if (order.getStatus() == Status.IN_PROGRESS) {
            orderModel.add(linkTo(methodOn(OrdersController.class).cancel(order.getId())).withRel("cancel"));
            orderModel.add(linkTo(methodOn(OrdersController.class).complete(order.getId())).withRel("complete"));
        }

        return orderModel;
    }


}
