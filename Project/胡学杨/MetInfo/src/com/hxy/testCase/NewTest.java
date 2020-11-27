package com.hxy.testCase;

import org.testng.annotations.Test;

import com.hxy.assertion.UpdateTitle_Assert;
import com.hxy.util.BaseAsset;

public class NewTest extends BaseAsset {
  @Test
  public void f() {
	  UpdateTitle_Assert a = new UpdateTitle_Assert(driver);
	  a.UpdateTitle_all_Assert();
  }
}
