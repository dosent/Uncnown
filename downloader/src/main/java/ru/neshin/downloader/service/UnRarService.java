package ru.neshin.downloader.service;

import com.github.junrar.Junrar;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class UnRarService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UnRarService.class);

    public boolean extract(String fileSource, String outDirectory) {
        boolean result = true;

        if (fileSource == null || outDirectory == null) {
            throw new IllegalArgumentException("Нулевые параметры при распаковки");
        }
        File file = new File(outDirectory);
        if (!file.isDirectory() && !file.mkdirs()) {
            throw new IllegalArgumentException("Не могу создать директорию распаковки");
        }
        file = new File(fileSource);
        if (!file.isFile()) {
            throw new IllegalArgumentException("Нет входного файла");
        }
        try {
            Junrar.extract(fileSource, outDirectory);
        } catch (Exception e) {
            LOGGER.error(e.getCause().getMessage(), e.getCause());
            result = false;
        } finally {
            return result;
        }
    }
}
