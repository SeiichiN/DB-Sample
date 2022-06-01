package model;

import dao.StateDAO;
import model.bean.State;

public class FindStateByIdLogic implements CommandInterface {
	public void execute() {}
	public void execute(State state) {
		StateDAO dao = new StateDAO();
		State _state = dao.findStateById(state.getSid());
		state.setSname(_state.getSname());
	}
}
