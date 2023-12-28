
package module8practice;

/**
 *
 * @author grant rynders
 */
public final class Module8Practice 
{
    private final String name;
    private final String title;

    public Module8Practice(String n, String t)
    {
        name = n;
        title = t;
        Module8Practice m = new Module8Practice("Hayden Christenson", "the territorial");
        System.out.println(m.Name() + " " + m.Title());
    }
    public String Name()
    {
        return name;
    }
    public String Title()
    {
        return title;
    }
}

