package com.bsiag.ethereum.fxtradingnetwork.client.common;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.bsiag.ethereum.fxtradingnetwork.client.common.AbstractEmailField;

/**
 * Test for {@link AbstractEmailField}
 */
public class EmailFieldTest {
  private AbstractEmailField testField;

  @Before
  public void before() {
    testField = new AbstractEmailField() {
    };

  }

  @Test
  public void testNullEmail() {
    testField.setValue(null);
    assertTrue(testField.isContentValid());
  }

  @Test
  public void testEmptyEmail() {
    testField.setValue("");
    assertTrue(testField.isContentValid());
  }

  @Test
  public void testInvalidEmail() {
    testField.setValue("a");
    assertFalse(testField.isContentValid());
  }

  @Test
  public void testValidEmail() {
    testField.setValue("a@b.ch");
    assertTrue(testField.isContentValid());
  }

}
