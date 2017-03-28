package MethodTest;

import java.util.Date;

/**
 * @author chengangw
 * @date 11/11/2016 3:15 PM
 */
public class Period {
    private Date startDt;
    private Date endDt;

    public Period() {
    }

    public Period(Date startDt, Date endDt) {
        if (startDt.compareTo(endDt) > 0) {
            throw new IllegalArgumentException(startDt + " after " + endDt);
        }
        this.startDt = startDt;
        this.endDt = endDt;
    }

    public Date getStartDt() {
        return startDt;
    }

    public void setStartDt(Date startDt) {
        this.startDt = startDt;
    }

    public Date getEndDt() {
        return endDt;
    }

    public void setEndDt(Date endDt) {
        this.endDt = endDt;
    }
}
