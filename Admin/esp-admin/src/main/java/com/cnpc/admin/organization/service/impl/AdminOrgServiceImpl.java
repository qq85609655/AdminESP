package com.cnpc.admin.organization.service.impl;

import com.cnpc.admin.basic.dao.DAO;
import com.cnpc.admin.entity.PageData;
import com.cnpc.admin.organization.service.IAdminOrgService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("adminOrgService")
public class AdminOrgServiceImpl implements IAdminOrgService {
    @Resource(name = "daoSupport")
    private DAO dao;

    /**
     * 参数为空，查询所有
     * @param pd
     * @return
     * @throws Exception
     */
    @Override
    public List<PageData> find(PageData pd) throws Exception {
        return (List<PageData>) dao.findForList("OrgAdminMapper.list",pd);
    }

    /**
     * 保存
     * @param pd
     * @throws Exception
     */
    @Override
    @Transactional
    public void save(PageData pd) throws Exception {
        dao.save("OrgAdminMapper.save",pd);
    }

    /**
     * 修改
     * @param pd
     * @throws Exception
     */
    @Override
    @Transactional
    public void update(PageData pd) throws Exception {
        dao.update("OrgAdminMapper.update",pd);
    }

    /**
     * 删除
     * @param pd
     * @throws Exception
     */
    @Override
    @Transactional
    public void deletedById(PageData pd) throws Exception {
        dao.update("OrgAdminMapper.deleted",pd);
    }

    /**
     * 唯一编码校验
     * @param pd
     * @return
     * @throws Exception
     */
    @Override
    public List<PageData> findOnlyCode(PageData pd) throws Exception {
        return (List<PageData>) dao.findForList("OrgAdminMapper,findOnlyCode",pd);
    }
}