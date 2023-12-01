public class Edinso
{
    public String getGreeting()
    {
        return "Hello, let's talk.";
    }

    public String getResponse(String statement)
    {
        String response = "";
        if (findKeyword(statement, "no") >= 0 )
        {
            response = "Why so negative?";
        } else if (findKeyword(statement, "mother") >= 0
                || findKeyword(statement, "father") >= 0
                || findKeyword(statement, "sister") >= 0
                || findKeyword(statement, "brother") >= 0)
        {
            response = "Tell me more about your family.";
        } else if (findKeyword(statement, "dog") >= 0
                || findKeyword(statement, "cat") >= 0 
                || findKeyword(statement, "rat") >= 0 
                || findKeyword(statement, "cockroach") >= 0)
        {
            response = "Tell me more about your pet.";
        }
        else if (findKeyword(statement, "Edinso") >= 0 )
        {
            response = "Hahaha, that's my name. :)";
        }
        else if (statement.trim().length() > 0 )
        {
            response = "Why so quiet?";
        }
        else
        {
            response = getRandomResponse();
        }
        return response;
    }

    /**
     * Search for one word in phrase. The search is not case sensitive. This method
     * will check that the given goal is not a substring of a longer string (so,
     * for example, "I know" does not contain "no").
     *
     * @param statement the string to search
     * @param goal the string to search for
     * @param startPos the character of the string to begin the search at
     * @return the index of the first occurrence of goal in statement or -1 if it's
     *     not found
     */
    private int findKeyword(String statement, String goal, int startPos)
    {
        String phrase = statement.trim();
        // The only change to incorporate the startPos is in
        // the line below
        int psn = phrase.toLowerCase().indexOf(goal.toLowerCase(), startPos);

        // Refinement--make sure the goal isn't part of a
        // word
        while (psn >= 0)
        {
            // Find the string of length 1 before and after
            // the word
            String before = " ", after = " ";
            if (psn > 0)
            {
                before = phrase.substring(psn - 1, psn).toLowerCase();
            }
            if (psn + goal.length() < phrase.length())
            {
                after =
                        phrase.substring(
                                        psn + goal.length(),
                                        psn + goal.length() + 1)
                                .toLowerCase();
            }

            /* determine the values of psn, before, and after at this point */

            // If before and after aren't letters, we've
            // found the word
            if (((before.compareTo("a") < 0)
                            || (before.compareTo("z") > 0)) // before is not a
                    // letter
                    && ((after.compareTo("a") < 0)
                            || (after.compareTo("z") > 0)))
            {
                return psn;
            }

            // The last position didn't work, so let's find
            // the next, if there is one.
            psn = phrase.indexOf(goal.toLowerCase(), psn + 1);
        }

        return -1;
    }

    /**
     * Search for one word in phrase. The search is not case sensitive. This method
     * will check that the given goal is not a substring of a longer string (so,
     * for example, "I know" does not contain "no"). The search begins at the
     * beginning of the string.
     *
     * @param statement the string to search
     * @param goal the string to search for
     * @return the index of the first occurrence of goal in statement or -1 if it's
     *     not found
     */

    private int findKeyword(String statement, String goal)
    {
        return findKeyword(statement, goal, 0);
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
