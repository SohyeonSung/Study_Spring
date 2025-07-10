package com.spring.biz.view.board;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteBoardController {

    @RequestMapping("/deleteBoard.do")
    public ModelAndView deleteBoard(@RequestParam("seq") int seq, BoardDAO boardDAO, ModelAndView mav) {
        System.out.println(">> 게시글 삭제 처리");

        // 1. 전달받은 글 번호를 VO에 설정
        BoardVO vo = new BoardVO();
        vo.setSeq(seq);

        // 2. DB 연동하여 게시글 삭제
        boardDAO.deleteBoard(vo);

        // 3. 목록 화면으로 리다이렉트
        mav.setViewName("redirect:getBoardList.do");

        return mav;
    }
}
