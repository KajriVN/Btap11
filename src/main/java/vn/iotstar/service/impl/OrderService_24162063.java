package vn.iotstar.service.impl;

import vn.iotstar.entity.OrderStatus_24162063;
import vn.iotstar.entity.Order_24162063;
import vn.iotstar.repository.IOrderRepository_24162063;
import vn.iotstar.repository.impl.OrderRepository_24162063;
import vn.iotstar.service.IOrderService_24162063;
import vn.iotstar.util.Constant_24162063;
import vn.iotstar.util.ParamUtil_24162063;

import java.time.LocalDateTime;
import java.util.regex.Pattern;

public class OrderService_24162063 implements IOrderService_24162063 {

    // So dien thoai VN: bat dau bang 0, 10-11 so
    private static final Pattern PHONE = Pattern.compile("^0\\d{9,10}$");

    private final IOrderRepository_24162063 orderRepository = new OrderRepository_24162063();

    @Override
    public Order_24162063 placeCodOrder(int userid, String receiverName, String phone, String address, String note) {
        String name = ParamUtil_24162063.trim(receiverName);
        String tel = ParamUtil_24162063.trim(phone);
        String addr = ParamUtil_24162063.trim(address);
        String memo = ParamUtil_24162063.trim(note);

        if (ParamUtil_24162063.isBlank(name) || name.length() > 50) {
            throw new IllegalArgumentException("Tên người nhận không được trống và tối đa 50 ký tự");
        }
        if (tel == null || !PHONE.matcher(tel).matches()) {
            throw new IllegalArgumentException("Số điện thoại phải gồm 10-11 số và bắt đầu bằng 0");
        }
        if (ParamUtil_24162063.isBlank(addr) || addr.length() > 255) {
            throw new IllegalArgumentException("Địa chỉ nhận hàng không được trống và tối đa 255 ký tự");
        }
        if (memo != null && memo.length() > 255) {
            throw new IllegalArgumentException("Ghi chú tối đa 255 ký tự");
        }

        Order_24162063 order = new Order_24162063();
        order.setReceiverName(name);
        order.setPhone(tel);
        order.setAddress(addr);
        order.setNote(ParamUtil_24162063.isBlank(memo) ? null : memo);
        order.setPaymentMethod(Constant_24162063.PAYMENT_COD);
        order.setStatus(OrderStatus_24162063.NEW);
        order.setCreatedAt(LocalDateTime.now());
        orderRepository.createFromCart(userid, order);
        return order;
    }

    @Override
    public Order_24162063 findByIdAndUser(int orderId, int userid) {
        return orderRepository.findByIdAndUser(orderId, userid);
    }
}
