package org.aptech.controller;

import org.aptech.entity.Person;
import org.aptech.entity.Phone;
import org.aptech.services.EntityService;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/person")
public class PersonController extends HttpServlet {

    @EJB
    EntityService<Person> personEntityService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String id = req.getParameter("id");
        if (action.equalsIgnoreCase("update")) {
            personEntityService.setType(Person.class);
            Person person = personEntityService.getEntityById(Long.valueOf(id));
            req.setAttribute("person", person);
            req.getServletContext().getRequestDispatcher("/UpdatePerson.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        personEntityService.setType(Person.class);
        String action = req.getParameter("action");
        String name = req.getParameter("name");
        String number1 = req.getParameter("number1");
        String number2 = req.getParameter("number2");
        if (action.equalsIgnoreCase("ADD")) {

            Person person = new Person();
            person.setName(name);
            Phone phone1 = new Phone();
            phone1.setNumber(number1);
            Phone phone2 = new Phone();
            phone2.setNumber(number2);
            person.getPhones().add(phone1);
            person.getPhones().add(phone2);
            personEntityService.addEntity(person);
            resp.getWriter().write("Create Person success");

        } else if (action.equalsIgnoreCase("update")) {

            personEntityService.setType(Person.class);
            String personId = req.getParameter("id");
            String personName = req.getParameter("name");
            Person person = personEntityService.getEntityById(Long.valueOf(personId));
            person.setName(personName);


            // Loop qua danh sach so dien thoai cua person
            for (Phone phone : person.getPhones()) {

                //Lay so dien thoai theo parameter tuong ung voi id. O trang update dat name = "number_" + phoneID
                String number = req.getParameter("number_" + phone.getId());
                phone.setNumber(number);

            }

            personEntityService.updateEntity(person);
            resp.getWriter().write("Update person success");


        }
    }
}
