package models;

public class Gate extends BaseModel {
    private Long gateNumber;
    private GateType gateType;
    private GateStatus gateStatus;
    private Operator currentOperator;

    public Long getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(Long gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public Operator getCurrentOperator() {
        return currentOperator;
    }

    public void setCurrentOperator(Operator currentOperator) {
        this.currentOperator = currentOperator;
    }
}
