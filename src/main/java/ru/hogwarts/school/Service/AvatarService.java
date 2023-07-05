package ru.hogwarts.school.Service;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.Entity.Avatar;
import ru.hogwarts.school.Entity.Student;
import ru.hogwarts.school.Exception.AvatarNotFoundException;
import ru.hogwarts.school.Exception.AvatarProcessingException;
import ru.hogwarts.school.Repositories.AvatarRepository;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
public class AvatarService {
    private final AvatarRepository avatarRepository;
    private final Path pathAvatarDir;

    public AvatarService(AvatarRepository avatarRepository, @Value("${path.to.avatar.dir}") String pathAvatarDir) {
        this.avatarRepository = avatarRepository;
        this.pathAvatarDir = Path.of(pathAvatarDir);
    }

    public Avatar create(Student student, MultipartFile multipartFile) {
        try {
            String contentType = multipartFile.getContentType();
            String extension = StringUtils.getFilenameExtension(multipartFile.getOriginalFilename());
            byte[] data = multipartFile.getBytes();
            String fileName = UUID.randomUUID().toString()+ " . " + extension;
            Path pathToAvatar = pathAvatarDir.resolve(fileName);
            Files.write(pathToAvatar, data);

            Avatar avatar = avatarRepository.findByStudent_Id(student.getId())
                    .orElse(new Avatar());
            avatar.setMediaType(contentType);
            avatar.setFileSize(data.length);
            avatar.setData(data);
            avatar.setStudent(student);
            avatar.setFilePath(pathToAvatar.toString());
            return avatarRepository.save(avatar);
        } catch (IOException e) {
            throw new AvatarProcessingException();
        }
    }

    public Pair<byte[], String> getFromDb(long id) {
        Avatar avatar = avatarRepository.findById(id)
                .orElseThrow(() -> new AvatarNotFoundException(id));
        return Pair.of(avatar.getData(), avatar.getMediaType());
    }

    public Pair<byte[], String> getFromFs(long id) {
        try {
            Avatar avatar = avatarRepository.findById(id)
                    .orElseThrow(() -> new AvatarNotFoundException(id));
            return Pair.of(Files.readAllBytes(Path.of(avatar.getFilePath())), avatar.getMediaType());
        } catch (IOException e) {
            throw new AvatarProcessingException();
        }
    }
}
