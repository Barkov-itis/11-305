package ru.itis.servlets;

import ru.itis.models.FileInfo;
import ru.itis.services.FilesService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/uploaded/files")
public class FilesServlet extends HttpServlet {

    private FilesService filesService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.filesService = (FilesService) config.getServletContext().getAttribute("filesUploadService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        String fileId = req.getParameter("id");
        // получили информацию о загруженном файле
        FileInfo fileInfo = filesService.getFileInfo(Long.parseLong(fileId));
        // в ответ указали какого-типа данные уйдут клиенту
        response.setContentType(fileInfo.getType());
        // в ответ указали какой размер данных
        response.setContentLength(fileInfo.getSize().intValue());
        // в ответ указали оригинальнгое название файла
        response.setHeader("Content-Disposition", "filename=\"" + fileInfo.getOriginalFileName() + "\"");
        // записываем данные самого файла в ответ
        filesService.writeFileFromStorage(Long.parseLong(fileId), response.getOutputStream());
        response.flushBuffer();
    }
}
