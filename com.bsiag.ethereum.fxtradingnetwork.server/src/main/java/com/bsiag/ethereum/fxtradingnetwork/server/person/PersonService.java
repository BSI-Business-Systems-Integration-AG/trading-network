/*******************************************************************************
 * Copyright (c) 2015 BSI Business Systems Integration AG.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Distribution License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/org/documents/edl-v10.html
 *
 * Contributors:
 *     BSI Business Systems Integration AG - initial API and implementation
 ******************************************************************************/
package com.bsiag.ethereum.fxtradingnetwork.server.person;

import java.util.UUID;

import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.exception.VetoException;
import org.eclipse.scout.rt.platform.holders.NVPair;
import org.eclipse.scout.rt.platform.util.StringUtility;
import org.eclipse.scout.rt.server.jdbc.SQL;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.jdbc.SearchFilter;
import org.eclipse.scout.rt.shared.services.common.security.ACCESS;

import com.bsiag.ethereum.fxtradingnetwork.server.account.EthereumService;
import com.bsiag.ethereum.fxtradingnetwork.server.account.model.Account;
import com.bsiag.ethereum.fxtradingnetwork.server.sql.SQLs;
import com.bsiag.ethereum.fxtradingnetwork.shared.person.IPersonService;
import com.bsiag.ethereum.fxtradingnetwork.shared.person.PersonCreatePermission;
import com.bsiag.ethereum.fxtradingnetwork.shared.person.PersonFormData;
import com.bsiag.ethereum.fxtradingnetwork.shared.person.PersonReadPermission;
import com.bsiag.ethereum.fxtradingnetwork.shared.person.PersonSearchFormData;
import com.bsiag.ethereum.fxtradingnetwork.shared.person.PersonTablePageData;
import com.bsiag.ethereum.fxtradingnetwork.shared.person.PersonUpdatePermission;

public class PersonService implements IPersonService {

  @Override
  public PersonTablePageData getPersonTableData(SearchFilter filter, String organizationId) {
    PersonTablePageData pageData = new PersonTablePageData();
    PersonSearchFormData searchData = (PersonSearchFormData) filter.getFormData();
    StringBuilder sql = new StringBuilder();

    sql.append(SQLs.PERSON_PAGE_SELECT);
    sql.append(" WHERE 1 = 1 ");
    addToWhere(sql, organizationId, "organization_id", "organizationId");

    if (searchData != null) {
      addToWhere(sql, searchData.getFirstName().getValue(), "first_name", "firstName");
      addToWhere(sql, searchData.getLastName().getValue(), "last_name", "lastName");
      addToWhere(sql, searchData.getLocation().getCity().getValue(), "city", "location.city");
      addToWhere(sql, searchData.getLocation().getCountry().getValue(), "country", "location.country");
      addToWhere(sql, searchData.getOrganization().getValue(), "organization_id", "organization");
    }

    sql.append(SQLs.PERSON_PAGE_DATA_SELECT_INTO);

    SQL.selectInto(sql.toString(), searchData, new NVPair("organizationId", organizationId), new NVPair("page", pageData));

    return pageData;
  }

  protected void addToWhere(StringBuilder sqlWhere, String fieldValue, String sqlAttribute, String searchAttribute) {
    if (StringUtility.hasText(fieldValue)) {
      sqlWhere.append(String.format(SQLs.AND_LIKE_CAUSE, sqlAttribute, searchAttribute));
    }
  }

  @Override
  public PersonFormData create(PersonFormData formData) {
    if (!ACCESS.check(new PersonCreatePermission())) {
      throw new VetoException(TEXTS.get("InsufficientPrivileges"));
    }

    if (StringUtility.isNullOrEmpty(formData.getPersonId())) {
      formData.setPersonId(UUID.randomUUID().toString());
    }

    SQL.insert(SQLs.PERSON_INSERT, formData);

    return store(formData);
  }

  @Override
  public PersonFormData load(PersonFormData formData) {
    if (!ACCESS.check(new PersonReadPermission())) {
      throw new VetoException(TEXTS.get("InsufficientPrivileges"));
    }

    SQL.selectInto(SQLs.PERSON_SELECT, formData);

    String personId = formData.getPersonId();
    Account wallet = null;

    if (personId.equals("prs01")) {
      wallet = BEANS.get(EthereumService.class).getWallet("0x8d2ec831056c620fea2fabad8bf6548fc5810cc3");
    }
    else if (personId.equals("prs01a")) {
      wallet = BEANS.get(EthereumService.class).getWallet("0xcbc12f306da804bb681aceeb34f0bc58ba2f7ad7");
    }

    formData.getWalletAddress().setValue(wallet.getAddress());
    formData.getWalletPath().setValue(wallet.getFile().getAbsolutePath());

    return formData;
  }

  @Override
  public PersonFormData store(PersonFormData formData) {
    if (!ACCESS.check(new PersonUpdatePermission())) {
      throw new VetoException(TEXTS.get("InsufficientPrivileges"));
    }

    SQL.update(SQLs.PERSON_UPDATE, formData);

    return formData;
  }
}
// end::all[]
// end::getTableData[]
