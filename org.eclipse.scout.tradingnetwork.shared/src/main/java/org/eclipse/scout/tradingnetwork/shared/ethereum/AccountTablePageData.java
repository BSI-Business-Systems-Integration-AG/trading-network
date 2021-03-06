package org.eclipse.scout.tradingnetwork.shared.ethereum;

import java.math.BigDecimal;

import javax.annotation.Generated;

import org.eclipse.scout.rt.shared.data.basic.table.AbstractTableRowData;
import org.eclipse.scout.rt.shared.data.page.AbstractTablePageData;

/**
 * <b>NOTE:</b><br>
 * This class is auto generated by the Scout SDK. No manual modifications recommended.
 */
@Generated(value = "org.eclipse.scout.tradingnetwork.client.ethereum.AccountTablePage", comments = "This class is auto generated by the Scout SDK. No manual modifications recommended.")
public class AccountTablePageData extends AbstractTablePageData {

  private static final long serialVersionUID = 1L;

  @Override
  public AccountTableRowData addRow() {
    return (AccountTableRowData) super.addRow();
  }

  @Override
  public AccountTableRowData addRow(int rowState) {
    return (AccountTableRowData) super.addRow(rowState);
  }

  @Override
  public AccountTableRowData createRow() {
    return new AccountTableRowData();
  }

  @Override
  public Class<? extends AbstractTableRowData> getRowType() {
    return AccountTableRowData.class;
  }

  @Override
  public AccountTableRowData[] getRows() {
    return (AccountTableRowData[]) super.getRows();
  }

  @Override
  public AccountTableRowData rowAt(int index) {
    return (AccountTableRowData) super.rowAt(index);
  }

  public void setRows(AccountTableRowData[] rows) {
    super.setRows(rows);
  }

  public static class AccountTableRowData extends AbstractTableRowData {

    private static final long serialVersionUID = 1L;
    public static final String person = "person";
    public static final String address = "address";
    public static final String accountName = "accountName";
    public static final String balance = "balance";
    private String m_person;
    private String m_address;
    private String m_accountName;
    private BigDecimal m_balance;

    public String getPerson() {
      return m_person;
    }

    public void setPerson(String newPerson) {
      m_person = newPerson;
    }

    public String getAddress() {
      return m_address;
    }

    public void setAddress(String newAddress) {
      m_address = newAddress;
    }

    public String getAccountName() {
      return m_accountName;
    }

    public void setAccountName(String newAccountName) {
      m_accountName = newAccountName;
    }

    public BigDecimal getBalance() {
      return m_balance;
    }

    public void setBalance(BigDecimal newBalance) {
      m_balance = newBalance;
    }
  }
}
