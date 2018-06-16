package ru.homeapp.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ru.homeapp.dao.UserDAO;
import ru.homeapp.model.User;

@Controller
public class AddBookController {
    @Autowired
    private UserDAO dao;

    @Autowired
    private AddBookBean bean;

    @GetMapping(path = "/add-user")
    public String addPartPage(ModelMap model) {
//    public String addPartPage(HttpSession session, ModelMap model) {
//        if (ensureLoggedIn(session)) return "redirect:/";

        model.addAttribute("addUserBean", bean);

        return "addPart";
    }

    @RequestMapping(path = "/add-user", method = RequestMethod.POST)
    public String postAddPart(@RequestParam String firstName,
                              @RequestParam String lastName,
                              @RequestParam String login,
                              ModelMap model) { //,
//                              HttpSession session) {

//        if (ensureLoggedIn(session)) return "redirect:/";

        User user;
        try {
            user = dao.createUser(firstName, lastName, login);
        } catch (Throwable t) {
            t.printStackTrace();

//            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Failed to add part: " + t.getMessage());

            return "error";
        }

        AddBookCompleteBean bean = new AddBookCompleteBean(user.getFirstName(),
                user.getLastName(), user.getLogin());

        model.addAttribute("bean", bean);

        return "addUserComplete";
    }

//    private static boolean ensureLoggedIn(HttpSession session) {
//        if (session.getAttribute("userName") == null) {
//            return true;
//        }
//        return false;
//    }
}
