import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args){

        get("/", (request, response) -> {
            Map<String,Object> model = new HashMap<>();
            return new ModelAndView(model, "form.hbs");
        }, new HandlebarsTemplateEngine());

        get("/change", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int amount = Integer.parseInt(request.queryParams("amount"));

            ChangeMachine amountQuarter = new ChangeMachine();
            String change = amountQuarter.makeChange((float)amount);

            model.put("change", change);
            return new ModelAndView(model, "change.hbs");
        }, new HandlebarsTemplateEngine());
    }
}
