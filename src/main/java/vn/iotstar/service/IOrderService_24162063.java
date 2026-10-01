package vn.iotstar.service;

import vn.iotstar.entity.Order_24162063;

public interface IOrderService_24162063 {

    /**
     * Dat hang toan bo gio hang, thanh toan khi nhan hang (COD).
     * @throws IllegalArgumentException neu thong tin nhan hang sai
     * @throws IllegalStateException neu gio trong / khong du hang
     */
    Order_24162063 placeCodOrder(int userid, String receiverName, String phone, String address, String note);

    Order_24162063 findByIdAndUser(int orderId, int userid);
}
