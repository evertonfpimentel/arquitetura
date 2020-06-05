package br.com.compasso.customer.util;

public enum ErrorMessage {
	DATABASE_ERROR("An error occurred while saving an order in database!"),
	DATABASE_NOT_FOUND("customer not found in database!"),
	GENERIC_ERROR("Internal server error"),
	INVALID_REQUEST("Invalid request"),
	INTERNAL_SERVER_ERROR("Internal server error");
	
	private final String description;
	
	private ErrorMessage(String description) {
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
