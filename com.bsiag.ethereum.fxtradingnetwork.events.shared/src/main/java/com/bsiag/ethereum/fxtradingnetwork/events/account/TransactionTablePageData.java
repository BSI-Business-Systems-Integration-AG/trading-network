package com.bsiag.ethereum.fxtradingnetwork.events.account;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.eclipse.scout.rt.shared.data.basic.table.AbstractTableRowData;
import org.eclipse.scout.rt.shared.data.page.AbstractTablePageData;

/**
 * <b>NOTE:</b><br>
 * This class is auto generated by the Scout SDK. No manual modifications recommended.
 */
@Generated(value = "com.bsiag.ethereum.fxtradingnetwork.events.account.TransactionTablePage", comments = "This class is auto generated by the Scout SDK. No manual modifications recommended.")
public class TransactionTablePageData extends AbstractTablePageData {

  private static final long serialVersionUID = 1L;

  @Override
  public TransactionTableRowData addRow() {
    return (TransactionTableRowData) super.addRow();
  }

  @Override
  public TransactionTableRowData addRow(int rowState) {
    return (TransactionTableRowData) super.addRow(rowState);
  }

  @Override
  public TransactionTableRowData createRow() {
    return new TransactionTableRowData();
  }

  @Override
  public Class<? extends AbstractTableRowData> getRowType() {
    return TransactionTableRowData.class;
  }

  @Override
  public TransactionTableRowData[] getRows() {
    return (TransactionTableRowData[]) super.getRows();
  }

  @Override
  public TransactionTableRowData rowAt(int index) {
    return (TransactionTableRowData) super.rowAt(index);
  }

  public void setRows(TransactionTableRowData[] rows) {
    super.setRows(rows);
  }

  public static class TransactionTableRowData extends AbstractTableRowData {

    private static final long serialVersionUID = 1L;
    public static final String id = "id";
    public static final String block = "block";
    public static final String hash = "hash";
    public static final String from = "from";
    public static final String to = "to";
    public static final String value = "value";
    public static final String status = "status";
    private String m_id;
    private Long m_block;
    private String m_hash;
    private String m_from;
    private String m_to;
    private BigDecimal m_value;
    private Integer m_status;

    public String getId() {
      return m_id;
    }

    public void setId(String newId) {
      m_id = newId;
    }

    public Long getBlock() {
      return m_block;
    }

    public void setBlock(Long newBlock) {
      m_block = newBlock;
    }

    public String getHash() {
      return m_hash;
    }

    public void setHash(String newHash) {
      m_hash = newHash;
    }

    public String getFrom() {
      return m_from;
    }

    public void setFrom(String newFrom) {
      m_from = newFrom;
    }

    public String getTo() {
      return m_to;
    }

    public void setTo(String newTo) {
      m_to = newTo;
    }

    public BigDecimal getValue() {
      return m_value;
    }

    public void setValue(BigDecimal newValue) {
      m_value = newValue;
    }

    public Integer getStatus() {
      return m_status;
    }

    public void setStatus(Integer newStatus) {
      m_status = newStatus;
    }
  }
}
