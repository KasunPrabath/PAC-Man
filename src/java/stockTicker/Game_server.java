package stockTicker;

import java.io.*;
import java.util.logging.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet(urlPatterns = {"/stream", "/UpdateGame", "/restart%20game"})
public final class Game_server extends HttpServlet {

    Board board;
    Players players;
    Game_Logic game_Logic;
    int session_count = 0;
    
    @Override
    public void init(final ServletConfig config) {
        this.board = new Board();
        this.players = new Players();
        this.game_Logic = new Game_Logic(players, board);
        
        Logger.getGlobal().log(Level.INFO, "Started stock price updates");
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        int x = (int) session.getAttribute("player");
        synchronized (this) {
            if(this.session_count >= 3){
            String key = request.getParameter("keypress");
            System.out.println("Received " + key);
            players.updatePosition(x, key);
            notifyAll();
            this.players.update();
            notifyAll();
            this.game_Logic.check_Logic();
            this.game_Logic.Check_status();
            notifyAll();
            Logger.getGlobal().log(Level.INFO, "Received " + key);
            }
            
        }
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
    }

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.isNew()) {
            this.session_count++;
            session.setAttribute("player", players.assignPlayer());
            players.playerCount++;
        }

        response.setContentType("text/event-stream; charset=UTF-8");
        try (final PrintWriter out = response.getWriter()) {
            String update;

            while (!Thread.interrupted()) {
                synchronized (this) {

                    update = "{" + board.get_position() + "," + players.get_position() + "}";
                    out.print("data: ");
                    out.println(update);
                    out.println();
                    out.flush();
                    wait();
                }

            }
        } catch (InterruptedException e) {
            throw new ServletException(e);
        }
    }
    
    @Override
    protected void doDelete(final HttpServletRequest request, final HttpServletResponse response)  //doDELETE
            throws ServletException, IOException {
            synchronized(this){
                
                if(this.session_count >= 4){
                    this.init(this);
                    this.session_count = 1;
                }
                notifyAll();
            }
        System.gc();
        Logger.getGlobal().log(Level.INFO, "Game Restarted");
    }

    @Override
    public void destroy() {
        
    }

}
