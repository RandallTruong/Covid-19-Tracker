package com.example.FinalJavaProject.Controller;
import com.example.FinalJavaProject.Models.Covid19Info;
import com.example.FinalJavaProject.Models.User;
import com.example.FinalJavaProject.Models.UsersRepo;
import org.apache.coyote.Request;
import org.json.JSONArray;
import com.example.FinalJavaProject.Models.Covid19InfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


@Controller
public class MainController {
    @Autowired
    Covid19InfoRepo covid19InfoRepo;

    @Autowired
    UsersRepo  usersRepo;

    /*
    @RequestMapping(value = { "/login" }, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

     */

    //Request mapping for homepage
    @RequestMapping("/")
    public ModelAndView Homepage() {
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }


    @RequestMapping( value = "/chart", method = RequestMethod.GET)
    public ModelAndView view(){
        ModelAndView mv = new ModelAndView("chart");

        CanvasjsChartData chartDataObject = new CanvasjsChartData();
        List<List<Map<Object, Object>>> canvasjsDataList = chartDataObject.getCanvasjsDataList(covid19InfoRepo.findAll());
        mv.addObject("dataPointsList", canvasjsDataList);

        //ParseAnotherJSONFile();

        return mv;
    }

    @RequestMapping(value = "/get", method = RequestMethod.GET)
    public ModelAndView get(@RequestParam("state") String state,
                            @RequestParam("date") String date) throws ParseException {

        System.out.println(date);
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse(date);
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyMMdd");
        String formattedDate = dateFormat2.format(date1);
        String covidInfo = getCovidInfoByStateAndDate(state, formattedDate);

        try {
            JSONObject json = new JSONObject(covidInfo);
            modelAndView.addObject("state", json.getString("state"));
            modelAndView.addObject("totalTestResults", json.getString("totalTestResults"));
            modelAndView.addObject("positive", json.getString("positive"));
            modelAndView.addObject("negative", json.getString("negative"));
            modelAndView.addObject("death", json.getString("death"));
            modelAndView.addObject("date", json.getString("date"));
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return modelAndView;
    }


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ModelAndView save(
            @RequestParam("state") String state,
            @RequestParam("totaltestresults") String totalTestResults,
            @RequestParam("positive") String positive,
            @RequestParam("negative") String negative,
            @RequestParam("death") String death,
            @RequestParam("date") String date
    ) {

        ModelAndView modelAndView = new ModelAndView("redirect:/");
        Covid19Info newInfo = new Covid19Info(state, totalTestResults, positive, negative, death, date);
        covid19InfoRepo.save(newInfo);
        return modelAndView;
    }

    @RequestMapping( value = "/loadcovidinfo", method = RequestMethod.GET)
    public ModelAndView page1() {
        ModelAndView mv = new ModelAndView("loadcovidinfo");
        mv.addObject("covidinfolist", covid19InfoRepo.findAll());
        return mv;
    }


    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView("redirect:/");
        covid19InfoRepo.deleteById(id);
        return modelAndView;
    }


    @RequestMapping(value = "/loadusersinfo", method = RequestMethod.GET)
    public ModelAndView page2() {
        ModelAndView mv = new ModelAndView("loadusersinfo");
        mv.addObject("userlist", usersRepo.findAll());
        return mv;
    }

    @RequestMapping(value = "/loadusersinfo/save", method = RequestMethod.POST)
    public ModelAndView save2(
                             @RequestParam("userName") String userName,
                             @RequestParam("firstName") String firstName,
                             @RequestParam("lastName") String lastName,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
                             @RequestParam("admin") boolean admin) {
        ModelAndView modelAndView = new ModelAndView("redirect:/loadusersinfo");
        User newUser = new User();
        newUser.setUserId(UUID.randomUUID().toString());
        newUser.setUserName(userName);
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setPassword(password);
        newUser.setAdmin(admin);
     usersRepo.save(newUser);
     return modelAndView;
    }

    @RequestMapping(value = "/loadusersinfo/delete/{id}", method = RequestMethod.GET)
    public ModelAndView userDelete(@PathVariable("id") String id){
        ModelAndView modelAndView = new ModelAndView("redirect:/loadusersinfo");
        usersRepo.deleteById(id);
        return modelAndView;
    }


    private String getCovidInfoByStateAndDate(String state, String date) {
        try {

            URL urlForGetRequest2 = new URL(
                    "https://api.covidtracking.com/v1/states/" + state + "/" + date +".json"
            );
            HttpURLConnection connection = (HttpURLConnection) urlForGetRequest2.openConnection();
            connection.setRequestMethod("GET");
            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;
                while ((line = in.readLine()) != null) {
                    response.append(line);
                }
                in.close();
                return response.toString();
            } else {
                return "Unexpected HTTP response";
            }
        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        }

    }



}