package com.smartlife.provider;

import com.smartlife.model.MusicInfoModel;
import org.apache.ibatis.jdbc.SQL;

import static com.smartlife.common.NettyConstants.BINDROBOT_TABLE;
import static com.smartlife.common.NettyConstants.COLLECTION_TABLE;

/**
 * Created by Administrator on 2017/6/8.
 */
public class CollectionDynaSqlProvider {
    public String insertLikeCollection(String pid,String cid){
        System.out.print("LikeDynaSqlProvider insertLikeCollection\n");
        return new SQL(){
            {
                INSERT_INTO(COLLECTION_TABLE);
                if(pid != null && !pid.equals("")){
                    VALUES("phoneId", "#{pid}");
                }
                if(cid != null && !cid.equals("")){
                    VALUES("collectionUri", "#{cid}");
                }
            }
        }.toString();
    }

    public String insertMusicData(MusicInfoModel musicinfo){
        System.out.print("LikeDynaSqlProvider insertMusicData\n");
        return new SQL(){
            {
                INSERT_INTO(BINDROBOT_TABLE);
            }
        }.toString();
    }
}
