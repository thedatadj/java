public class Edinso
{
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }

    public String getResponse(String statement)
    {
        String response = "";
        if (statement.indexOf("no") >= 0)
        {
            response = "Why so negative?";
        } else if (statement.indexOf("mother") >= 0
                || statement.indexOf("father") >= 0
                || statement.indexOf("sister") >= 0
                || statement.indexOf("brother") >= 0)
        {
            response = "Tell me more about your family.";
        }
        else if (statement.indexOf("dog") >= 0 ||
                 statement.indexOf("cat") >= 0 ||
                 statement.indexOf("rat") >= 0 ||
                 statement.indexOf("cockroach")  )
        {
            response = "Tell me more about your pet.";
        }
        else if (statement.indexOf("Edinso") >= 0 )
        {
            response = "Hahaha, that's my name. :)";
        }
        else if (statement.trim() > 0 )
        {
            response = "Why so quit?";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }

    private String getRandomResponse()
    {
        final int NUMBER_OF_RESPONSES = 6;
        double r = Math.random();
        int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
        String response = "";

        if (whichResponse == 0)
        {
            response = "Interesting, tell me more.";
        }
        else if (whichResponse == 1)
        {
            response = "Hmmm.";
        }
        else if (whichResponse == 2)
        {
            response = "Do you really think so?";
        }
        else if (whichResponse == 3)
        {
            response = "You don't say.";
        }
        else if (whichResponse == 4)
        {
            response = "Scooby dooo!! Pa! Pa!.";
        }
        else if (whichResponse == 5)
        {
            response = "Watagatapitusberry.";
        }
        return response;
    }

    public static void main(String[] args)
    {
        Edinso edi = new Edinso();

        System.out.println(edi.getGreeting());
        System.out.println(">My mother and I talked last night.");
        System.out.println(
                edi.getResponse("My mother and I talked last night."));
        System.out.println(">I said no.");
        System.out.println(edi.getResponse("I said no!"));
        System.out.println(">The weather is nice.");
        System.out.println(edi.getResponse("The weather is nice."));
        System.out.println(">Do you know my brother?");
        System.out.println(edi.getResponse("Do you know my brother?"));
    }
}

