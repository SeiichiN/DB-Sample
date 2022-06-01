package model;

import dao.GenderDAO;
import model.bean.Gender;

public class FindGenderByIdLogic implements CommandInterface {
	public void execute() {}
	public void execute(Gender gender) {
		GenderDAO dao = new GenderDAO();
		Gender _gender = dao.findGenderById(gender.getGid());
		gender.setGname(_gender.getGname());
	}
}
