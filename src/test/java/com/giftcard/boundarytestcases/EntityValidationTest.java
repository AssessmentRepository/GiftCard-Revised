package com.giftcard.boundarytestcases;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.giftcard.dtos.GiftCardOrderDetailsDTO;
import com.giftcard.utilityclasses.MasterData;

@RunWith(JUnitPlatform.class)
public class EntityValidationTest {
	static {
		File file = new File("output_boundary_revised.txt");
		if (file.exists()) {
			try {
				FileUtils.forceDelete(new File("output_boundary_revised.txt"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}
		}
	}

	private Validator validator;

	@BeforeEach
	public void setUp() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
	}

	@Test
	public void testGiftOrdersSuccess() {
		try {
			GiftCardOrderDetailsDTO details = MasterData.getDetails();
			Set<ConstraintViolation<GiftCardOrderDetailsDTO>> violations = validator.validate(details);
			File file = new File("output_boundary_revised.txt");
			FileUtils.write(file, "testGiftOrdersSuccess=" + (violations == details ? true : false), true);
			Assert.assertEquals(violations, new Integer(0));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}