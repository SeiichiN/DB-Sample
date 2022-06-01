package listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import util.Const;
import util.OptState;

@WebListener
public class OptionState implements ServletContextListener {


    public OptionState() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }

    /**
     * 都道府県の <option>リストをつくる。
     * これを registInput.jsp で <select>につかう
     */
    public void contextInitialized(ServletContextEvent sce)  { 
		List<OptState> optStateList = new ArrayList<>();
		for (String[] ken : Const.state) {
			OptState optState = new OptState(ken[0], ken[1]);
			optStateList.add(optState);
		}
		ServletContext context = sce.getServletContext();
		context.setAttribute("optStateList", optStateList);
    }
	
}
