package com.spring.biz.view.board;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class GetBoardController {

    @RequestMapping("/getBoard.do")
    public String getBoard(String seq, Model model) {
        System.out.println(">> 게시글 조회(상세보기)");

        // 1. 전달받은 데이터 확인 및 가공
        BoardVO vo = new BoardVO();
        vo.setSeq(Integer.parseInt(seq));

        // 2. 게시글 1개 조회
        BoardDAO boardDAO = new BoardDAO();
        BoardVO board = boardDAO.getBoard(vo);

        // 3. 뷰에서 사용하도록 Model에 데이터 저장
        model.addAttribute("board", board);

        // 4. View 페이지로 이동
        return "getBoard.jsp";
    }
}
