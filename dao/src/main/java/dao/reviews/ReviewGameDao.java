package dao.reviews;

import dao.BaseDao;
import entity.reviews.ReviewGame;

/**
 * Created by User on 15.06.2017.
 */
public class ReviewGameDao extends BaseDao<ReviewGame> {
    public ReviewGameDao() {
        super(ReviewGame.class);
    }
}
