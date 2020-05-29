package com.giftcard.services;

import java.util.List;

import com.giftcard.dtos.GiftCardOrderDetailsDTO;



public interface GiftCardOrderService {
    /**
     * 
     * @return list of gift orders
     */
	List<GiftCardOrderDetailsDTO> getAllOrderDetails();

	/**
	 * 
	 * @param giftCardOrderDetails
	 * @return boolean true for successfully saving
	 */
	Boolean saveGiftCardOrderDetail(GiftCardOrderDetailsDTO giftCardOrderDetails);

}
