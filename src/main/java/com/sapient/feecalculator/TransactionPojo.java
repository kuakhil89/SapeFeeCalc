package com.sapient.feecalculator;

public class TransactionPojo {

    private String externalTransactionID;
    private String clientId;
    private String securityId;
    private Integer transactionType;
    private java.util.Date transactionDate;
    private Double marketValue;
    private Boolean priority;
    private Double transactionFees;

    public String getExternalTransactionID() {
        return externalTransactionID;
    }

    public void setExternalTransactionID(String externalTransactionID) {
        this.externalTransactionID = externalTransactionID;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String securityId) {
        this.securityId = securityId;
    }

    public Integer getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(Integer transactionType) {
        this.transactionType = transactionType;
    }

    public java.util.Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(java.util.Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Double getMarketValue() {
        return marketValue;
    }

    public void setMarketValue(Double marketValue) {
        this.marketValue = marketValue;
    }

    public Boolean getPriority() {
        return priority;
    }

    public void setPriority(Boolean priority) {
        this.priority = priority;
    }

    public Double getTransactionFees() {
        return transactionFees;
    }

    public void setTransactionFees(Double transactionFees) {
        this.transactionFees = transactionFees;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransactionPojo [externalTransactionID=");
		builder.append(externalTransactionID);
		builder.append(", clientId=");
		builder.append(clientId);
		builder.append(", securityId=");
		builder.append(securityId);
		builder.append(", transactionType=");
		builder.append(transactionType);
		builder.append(", transactionDate=");
		builder.append(transactionDate);
		builder.append(", marketValue=");
		builder.append(marketValue);
		builder.append(", priority=");
		builder.append(priority);
		builder.append(", transactionFees=");
		builder.append(transactionFees);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
		result = prime * result + ((externalTransactionID == null) ? 0 : externalTransactionID.hashCode());
		result = prime * result + ((marketValue == null) ? 0 : marketValue.hashCode());
		result = prime * result + ((priority == null) ? 0 : priority.hashCode());
		result = prime * result + ((securityId == null) ? 0 : securityId.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((transactionFees == null) ? 0 : transactionFees.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionPojo other = (TransactionPojo) obj;
		if (clientId == null) {
			if (other.clientId != null)
				return false;
		} else if (!clientId.equals(other.clientId))
			return false;
		if (externalTransactionID == null) {
			if (other.externalTransactionID != null)
				return false;
		} else if (!externalTransactionID.equals(other.externalTransactionID))
			return false;
		if (marketValue == null) {
			if (other.marketValue != null)
				return false;
		} else if (!marketValue.equals(other.marketValue))
			return false;
		if (priority == null) {
			if (other.priority != null)
				return false;
		} else if (!priority.equals(other.priority))
			return false;
		if (securityId == null) {
			if (other.securityId != null)
				return false;
		} else if (!securityId.equals(other.securityId))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionFees == null) {
			if (other.transactionFees != null)
				return false;
		} else if (!transactionFees.equals(other.transactionFees))
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		return true;
	}
    

}
