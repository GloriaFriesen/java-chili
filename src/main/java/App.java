import java.util.Map;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;
import static spark.Spark.*;

public class App {
  public static void main(String[] args) {
    staticFileLocation("/public");
    String layout = "templates/layout.vtl";

    get("/", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/chili", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String chiliName = request.queryParams("chili");
      Chili newChili = new Chili(chiliName);
      request.session().attribute("chiliPrime", newChili.all());
      model.put("template", "templates/index.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/chili/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("template", "templates/chili-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/chilis", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      model.put("chiliKey", request.session().attribute("chiliPrime"));

      model.put("template", "templates/chilis.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/chilis/:chili_id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Chili newChili = Chili.find(Integer.parseInt(request.params(":chili_id")));
      model.put("chili", newChili);
      model.put("template", "templates/chili.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());


    get("/chilis/:chili_id/bean/new", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Chili newChili = Chili.find(Integer.parseInt(request.params(":chili_id")));
      model.put("chili", newChili);
      model.put("template", "templates/bean-form.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    post("/chilis/:chili_id/bean", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      String bean = request.queryParams("bean");
      Bean newBean = new Bean(bean);
      request.session().attribute("beanPrime", newBean.all());
      Chili newChili = Chili.find(Integer.parseInt(request.params(":chili_id")));
      model.put("chili", newChili);
      model.put("beanKey", newBean.all());
      model.put("template", "templates/new-bean.vtl");
      model.put("bean", newBean);
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

    get("/chilis/:chili_id/bean/:bean_id", (request, response) -> {
      Map<String, Object> model = new HashMap<String, Object>();
      Bean newBean = Bean.find(Integer.parseInt(request.params(":bean_id")));
      model.put("bean", newBean);
      model.put("template", "templates/bean.vtl");
      return new ModelAndView(model, layout);
    }, new VelocityTemplateEngine());

  }
}
