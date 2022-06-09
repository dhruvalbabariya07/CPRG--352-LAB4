package servlets;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;


public class NoteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Variables
        String title = "";
        String contentWithBR = "";
        String currentContent;
        String path = getServletContext().getRealPath("/WEB-INF/note1.txt");
        // To read files
        BufferedReader brw = new BufferedReader(new FileReader(new File(path)));
        // To store title (first line)
        title = brw.readLine() ;
        // To store rest of the content
        while ((currentContent = brw.readLine()) != null){
         contentWithBR = currentContent +  contentWithBR;
        }
       
        String content = contentWithBR.replace("<br>", "\r\n");
        // Close the file
        brw.close();
        Note note = new Note(title, content);
        request.setAttribute("Note", note);
        if(request.getParameter("edit") == null){
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            return;
        }
        else
        {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
        }
            return;
    }
       @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        String title = request.getParameter("title");
        String contentwithBR = request.getParameter("content");
        String contents =  contentwithBR.replace("\r\n", "<br>");
        Note note = new Note(title, contents);
        request.setAttribute("Note", note);
        PrintWriter pwd = new PrintWriter(new BufferedWriter(new FileWriter(path))); 
        pwd.write(title + "\n" + contents);
        pwd.close(); 
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        return;
    }

   

}
