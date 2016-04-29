package templates.carpooling.impl;

import templates.carpooling.DataValidator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DataValidatorImpl implements DataValidator {

	@Override
	public boolean dateValidate(String dateToValidate, String dateFormat){
		if(dateToValidate == null){
			return false;
		}

		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		sdf.setLenient(false);

		try {
			Date date = sdf.parse(dateToValidate);

		} catch (ParseException e) {
			//e.printStackTrace();
			return false;
		} catch (Exception ex) {
			return false;
		}

		return true;
	}

}
