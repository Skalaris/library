package pl.sda.library.model;

import java.util.Optional;

public class PaperBookBuilder {

    private String authorFirstName;
    private String authorLastName;
    private String title;
    private CoverKind coverKind;
    private int pageCount;

    public PaperBookBuilder authorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
        return this;
    }

    public PaperBookBuilder authorLastName(String authorLastName) {
        this.authorLastName = authorLastName;
        return this;
    }

    public PaperBookBuilder title(String title) {
        this.title = title;
        return this;
    }

    public PaperBookBuilder cover(CoverKind coverKind) {
        this.coverKind = coverKind;
        return this;
    }

    public PaperBookBuilder pageCount(int pageCount){
        this.pageCount=pageCount;
        return this;
    }

    public PaperBook build() {
        PaperBook book = new PaperBook();
        Creator author = new Creator();
        author.setFirstName(authorFirstName);
        author.setLastName(authorLastName);
        book.setAuthor(author);
        book.setTitle(title);
        book.setPageCount(pageCount);
        Optional<CoverKind> coverKindOptional = Optional.ofNullable(this.coverKind);
        book.setCoverKind(coverKindOptional.orElse(CoverKind.SOFT));
        /*if(coverKind!=null){
            book.setCoverKind(coverKind);
        }else {
            book.setCoverKind(CoverKind.HARD);
        }*/
        //book.setCoverKind(coverKind);
        return book;
    }

}