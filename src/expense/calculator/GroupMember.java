/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package expense.calculator;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author temp
 */
public class GroupMember {
    
    
    
    String member_name;
    String member_email;
    
    private String id;
    
    private Groups gp;
    private GroupAdmin gad;
    
    public GroupMember(String mn,String me)
    {
        member_name = mn;
        member_email = me;
        id=getGroupMemberCurrentId(mn);
    }
    public void Groups(Groups newgp)
    {
        this.gp = newgp;
    }
    public void GroupAdmin(GroupAdmin newgad)
    {
        this.gad = newgad;
    }
    
    public void setMName(String mname)
    {
        member_name = mname;
    }
     public void setMEmail(String memail)
    {
        member_email = memail;
    }
      
    public String getMName()
      {
          return member_name;
         
      }
       public String getMEmail()
      {
          return member_email;
         
      }
       
        public static String getGroupMemberCurrentId(String gMname)
    {
        Calendar calendar = Calendar.getInstance();
    DateFormat dateFormat = new SimpleDateFormat("yy-MMM-dd");
    Calendar cal = Calendar.getInstance();
        char f;
          char l;
              char hyphen='-';
        if(gMname.charAt(0)==' ')
            f='X';
            else
             f=gMname.charAt(0);
     
       
        if(gMname.indexOf(" ")>0 &&gMname.indexOf(" ")<gMname.length())
        {
             int index1 =gMname.indexOf(" ");
                 l=gMname.charAt(index1+1);
        }
        else
            l='X';
  
         f = Character.toUpperCase(f);
         l = Character.toUpperCase(l);
         
         String dte= dateFormat.format(cal.getTime());
         String year,month,oe;
         int index=0;
         index =dte.indexOf("-");
         year=dte.substring(0,index);
         index++;
         int sv =index;
         index = dte.indexOf("-", index);
          month=dte.substring(sv,index).toUpperCase();
          index++;
         
          oe=dte.substring(index).toUpperCase();
          int oE =Integer.parseInt(oe);
          if(oE%2==0)
              oe="E";
          else
              oe="O";  
         return  year+hyphen+month+hyphen+oe+hyphen+f+l;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public  void GroupMemberDisplay()
    {
        System.out.println("Group Member ID : "+getId());
        System.out.println("Group Member Name : "+getMName());
        System.out.println("group Member Email : "+getMEmail());
    }
    
}
