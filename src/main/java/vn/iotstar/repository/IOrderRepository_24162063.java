package vn.iotstar.repository;

import vn.iotstar.entity.Order_24162063;

public interface IOrderRepository_24162063 {

    /**
     * Tao don tu gio hang cua user trong 1 transaction:
     * tru kho tung sach, luu don + chi tiet, xoa gio hang.
     * @throws IllegalStateException neu gio trong / khong du hang (rollback het)
     */
    void createFromCart(int userid, Order_24162063 order);

    /** Lay don kem chi tiet, chi tra ve neu don thuoc ve user nay. */
    Order_24162063 findByIdAndUser(int orderId, int userid);
}
