package com.spring.biz.view.board;

import com.spring.biz.board.BoardVO;
import com.spring.biz.board.impl.BoardDAO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class GetBoardListController {

    @RequestMapping("/getBoardList.do")
    public ModelAndView getBoardList(
            @RequestParam(value = "searchCondition", required = false) String condition,
            @RequestParam(value = "searchKeyword", required = false) String keyword,
            BoardDAO boardDAO,
            ModelAndView mav) {

        System.out.println(">> 게시글 목록 처리 (전체조회 + 검색)");

        // DAO 호출 시 null 또는 빈 문자열 전달 가능
        List<BoardVO> boardList = boardDAO.getBoardList(condition, keyword);

        // 결과를 view에 전달
        mav.addObject("boardList", boardList);
        mav.setViewName("getBoardList.jsp");

        return mav;
    }
}
