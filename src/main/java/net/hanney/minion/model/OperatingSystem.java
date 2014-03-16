package net.hanney.minion.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Model that defines an Operating System which may run on a particular Server
 *
 * @author justin.hanney
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "operating_systems")
public class OperatingSystem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "operating_system_id")
    private String operatingSystemId;

    @Column(name = "operating_system_name")
    private String operatingSystemName;

    @Column(name = "create_date")
    private Date createDate;

    public OperatingSystem() {
        super();
    }

    public String getOperatingSystemId() {
        return operatingSystemId;
    }

    public void setOperatingSystemId(final String operatingSystemId) {
        this.operatingSystemId = operatingSystemId;
    }

    public String getOperatingSystemName() {
        return operatingSystemName;
    }

    public void setOperatingSystemName(final String operatingSystemName) {
        this.operatingSystemName = operatingSystemName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(final Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("operatingSystemId", getOperatingSystemId())
                .append("operatingSystemName", getOperatingSystemName())
                .append("createDate", getCreateDate())
                .toString();
    }

}
