package br.edu.utfpr.md.webapp.dao;

import br.edu.utfpr.md.model.Tag;
import com.mongodb.MongoClient;
import javax.inject.Inject;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

public class TagDAO extends BasicDAO<Tag, ObjectId>{
    @Inject
    public TagDAO(MongoClient mongoClient) {
        super(Tag.class, mongoClient, new Morphia(), MongoClientProvider.DATABASE);
    }
    
    public Tag getById(ObjectId id) {
        return this.getDatastore().find(Tag.class).field("_id").equal(id).get();
    }
}
