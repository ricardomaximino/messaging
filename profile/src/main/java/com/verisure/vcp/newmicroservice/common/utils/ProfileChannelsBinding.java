package com.verisure.vcp.newmicroservice.common.utils;

/**
 * The Class ProfileChannelsBinding.
 */
public class ProfileChannelsBinding {
	
	/** The Constant SEND_PROFILE_CREATED_EVENT. */
	public static final String SEND_PROFILE_CREATED_EVENT = "sendProfileCreatedEvent";
	
	/** The Constant SEND_PROFILE_UPDATED_EVENT. */
	public static final String SEND_PROFILE_UPDATED_EVENT = "sendProfileUpdatedEvent";
	
	/** The Constant SEND_PROFILE_DELETED_EVENT. */
	public static final String SEND_PROFILE_DELETED_EVENT = "sendProfileDeletedEvent";
	

	/**
	 * Instantiates a new profile channels binding.
	 *
	 * @throws IllegalAccessException the illegal access exception
	 */
	private ProfileChannelsBinding() throws IllegalAccessException {
		throw new IllegalAccessException("This class should not be initialized");
	}
}
