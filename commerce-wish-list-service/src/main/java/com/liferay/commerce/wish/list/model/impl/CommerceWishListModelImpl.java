/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.commerce.wish.list.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.wish.list.model.CommerceWishList;
import com.liferay.commerce.wish.list.model.CommerceWishListModel;
import com.liferay.commerce.wish.list.model.CommerceWishListSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the CommerceWishList service. Represents a row in the &quot;CommerceWishList&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CommerceWishListModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceWishListImpl}.
 * </p>
 *
 * @author Andrea Di Giorgi
 * @see CommerceWishListImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CommerceWishListModelImpl
	extends BaseModelImpl<CommerceWishList> implements CommerceWishListModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce wish list model instance should use the <code>CommerceWishList</code> interface instead.
	 */
	public static final String TABLE_NAME = "CommerceWishList";

	public static final Object[][] TABLE_COLUMNS = {
		{"uuid_", Types.VARCHAR}, {"commerceWishListId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"name", Types.VARCHAR}, {"defaultWishList", Types.BOOLEAN}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("uuid_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("commerceWishListId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("name", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("defaultWishList", Types.BOOLEAN);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CommerceWishList (uuid_ VARCHAR(75) null,commerceWishListId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,defaultWishList BOOLEAN)";

	public static final String TABLE_SQL_DROP = "drop table CommerceWishList";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceWishList.name ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CommerceWishList.name ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.wish.list.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.commerce.wish.list.model.CommerceWishList"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.wish.list.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.commerce.wish.list.model.CommerceWishList"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.wish.list.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.commerce.wish.list.model.CommerceWishList"),
		true);

	public static final long COMPANYID_COLUMN_BITMASK = 1L;

	public static final long CREATEDATE_COLUMN_BITMASK = 2L;

	public static final long DEFAULTWISHLIST_COLUMN_BITMASK = 4L;

	public static final long GROUPID_COLUMN_BITMASK = 8L;

	public static final long USERID_COLUMN_BITMASK = 16L;

	public static final long UUID_COLUMN_BITMASK = 32L;

	public static final long NAME_COLUMN_BITMASK = 64L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceWishList toModel(CommerceWishListSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		CommerceWishList model = new CommerceWishListImpl();

		model.setUuid(soapModel.getUuid());
		model.setCommerceWishListId(soapModel.getCommerceWishListId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setDefaultWishList(soapModel.isDefaultWishList());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceWishList> toModels(
		CommerceWishListSoap[] soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommerceWishList> models = new ArrayList<CommerceWishList>(
			soapModels.length);

		for (CommerceWishListSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.wish.list.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.wish.list.model.CommerceWishList"));

	public CommerceWishListModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceWishListId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceWishListId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceWishListId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceWishList.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceWishList.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<CommerceWishList, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<CommerceWishList, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceWishList, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((CommerceWishList)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<CommerceWishList, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<CommerceWishList, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceWishList)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<CommerceWishList, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<CommerceWishList, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, CommerceWishList>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceWishList.class.getClassLoader(), CommerceWishList.class,
			ModelWrapper.class);

		try {
			Constructor<CommerceWishList> constructor =
				(Constructor<CommerceWishList>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException roe) {
					throw new InternalError(roe);
				}
			};
		}
		catch (NoSuchMethodException nsme) {
			throw new InternalError(nsme);
		}
	}

	private static final Map<String, Function<CommerceWishList, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<CommerceWishList, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<CommerceWishList, Object>>
			attributeGetterFunctions =
				new LinkedHashMap<String, Function<CommerceWishList, Object>>();
		Map<String, BiConsumer<CommerceWishList, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<CommerceWishList, ?>>();

		attributeGetterFunctions.put(
			"uuid",
			new Function<CommerceWishList, Object>() {

				@Override
				public Object apply(CommerceWishList commerceWishList) {
					return commerceWishList.getUuid();
				}

			});
		attributeSetterBiConsumers.put(
			"uuid",
			new BiConsumer<CommerceWishList, Object>() {

				@Override
				public void accept(
					CommerceWishList commerceWishList, Object uuid) {

					commerceWishList.setUuid((String)uuid);
				}

			});
		attributeGetterFunctions.put(
			"commerceWishListId",
			new Function<CommerceWishList, Object>() {

				@Override
				public Object apply(CommerceWishList commerceWishList) {
					return commerceWishList.getCommerceWishListId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceWishListId",
			new BiConsumer<CommerceWishList, Object>() {

				@Override
				public void accept(
					CommerceWishList commerceWishList,
					Object commerceWishListId) {

					commerceWishList.setCommerceWishListId(
						(Long)commerceWishListId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function<CommerceWishList, Object>() {

				@Override
				public Object apply(CommerceWishList commerceWishList) {
					return commerceWishList.getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer<CommerceWishList, Object>() {

				@Override
				public void accept(
					CommerceWishList commerceWishList, Object groupId) {

					commerceWishList.setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function<CommerceWishList, Object>() {

				@Override
				public Object apply(CommerceWishList commerceWishList) {
					return commerceWishList.getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer<CommerceWishList, Object>() {

				@Override
				public void accept(
					CommerceWishList commerceWishList, Object companyId) {

					commerceWishList.setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function<CommerceWishList, Object>() {

				@Override
				public Object apply(CommerceWishList commerceWishList) {
					return commerceWishList.getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer<CommerceWishList, Object>() {

				@Override
				public void accept(
					CommerceWishList commerceWishList, Object userId) {

					commerceWishList.setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function<CommerceWishList, Object>() {

				@Override
				public Object apply(CommerceWishList commerceWishList) {
					return commerceWishList.getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer<CommerceWishList, Object>() {

				@Override
				public void accept(
					CommerceWishList commerceWishList, Object userName) {

					commerceWishList.setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function<CommerceWishList, Object>() {

				@Override
				public Object apply(CommerceWishList commerceWishList) {
					return commerceWishList.getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer<CommerceWishList, Object>() {

				@Override
				public void accept(
					CommerceWishList commerceWishList, Object createDate) {

					commerceWishList.setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function<CommerceWishList, Object>() {

				@Override
				public Object apply(CommerceWishList commerceWishList) {
					return commerceWishList.getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer<CommerceWishList, Object>() {

				@Override
				public void accept(
					CommerceWishList commerceWishList, Object modifiedDate) {

					commerceWishList.setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"name",
			new Function<CommerceWishList, Object>() {

				@Override
				public Object apply(CommerceWishList commerceWishList) {
					return commerceWishList.getName();
				}

			});
		attributeSetterBiConsumers.put(
			"name",
			new BiConsumer<CommerceWishList, Object>() {

				@Override
				public void accept(
					CommerceWishList commerceWishList, Object name) {

					commerceWishList.setName((String)name);
				}

			});
		attributeGetterFunctions.put(
			"defaultWishList",
			new Function<CommerceWishList, Object>() {

				@Override
				public Object apply(CommerceWishList commerceWishList) {
					return commerceWishList.getDefaultWishList();
				}

			});
		attributeSetterBiConsumers.put(
			"defaultWishList",
			new BiConsumer<CommerceWishList, Object>() {

				@Override
				public void accept(
					CommerceWishList commerceWishList, Object defaultWishList) {

					commerceWishList.setDefaultWishList(
						(Boolean)defaultWishList);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public String getUuid() {
		if (_uuid == null) {
			return "";
		}
		else {
			return _uuid;
		}
	}

	@Override
	public void setUuid(String uuid) {
		_columnBitmask |= UUID_COLUMN_BITMASK;

		if (_originalUuid == null) {
			_originalUuid = _uuid;
		}

		_uuid = uuid;
	}

	public String getOriginalUuid() {
		return GetterUtil.getString(_originalUuid);
	}

	@JSON
	@Override
	public long getCommerceWishListId() {
		return _commerceWishListId;
	}

	@Override
	public void setCommerceWishListId(long commerceWishListId) {
		_commerceWishListId = commerceWishListId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_columnBitmask |= COMPANYID_COLUMN_BITMASK;

		if (!_setOriginalCompanyId) {
			_setOriginalCompanyId = true;

			_originalCompanyId = _companyId;
		}

		_companyId = companyId;
	}

	public long getOriginalCompanyId() {
		return _originalCompanyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_columnBitmask |= USERID_COLUMN_BITMASK;

		if (!_setOriginalUserId) {
			_setOriginalUserId = true;

			_originalUserId = _userId;
		}

		_userId = userId;
	}

	@Override
	public String getUserUuid() {
		try {
			User user = UserLocalServiceUtil.getUserById(getUserId());

			return user.getUuid();
		}
		catch (PortalException pe) {
			return "";
		}
	}

	@Override
	public void setUserUuid(String userUuid) {
	}

	public long getOriginalUserId() {
		return _originalUserId;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return "";
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask |= CREATEDATE_COLUMN_BITMASK;

		if (_originalCreateDate == null) {
			_originalCreateDate = _createDate;
		}

		_createDate = createDate;
	}

	public Date getOriginalCreateDate() {
		return _originalCreateDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return "";
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask = -1L;

		_name = name;
	}

	@JSON
	@Override
	public boolean getDefaultWishList() {
		return _defaultWishList;
	}

	@JSON
	@Override
	public boolean isDefaultWishList() {
		return _defaultWishList;
	}

	@Override
	public void setDefaultWishList(boolean defaultWishList) {
		_columnBitmask |= DEFAULTWISHLIST_COLUMN_BITMASK;

		if (!_setOriginalDefaultWishList) {
			_setOriginalDefaultWishList = true;

			_originalDefaultWishList = _defaultWishList;
		}

		_defaultWishList = defaultWishList;
	}

	public boolean getOriginalDefaultWishList() {
		return _originalDefaultWishList;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(
			PortalUtil.getClassNameId(CommerceWishList.class.getName()));
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), CommerceWishList.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceWishList toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, CommerceWishList>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		CommerceWishListImpl commerceWishListImpl = new CommerceWishListImpl();

		commerceWishListImpl.setUuid(getUuid());
		commerceWishListImpl.setCommerceWishListId(getCommerceWishListId());
		commerceWishListImpl.setGroupId(getGroupId());
		commerceWishListImpl.setCompanyId(getCompanyId());
		commerceWishListImpl.setUserId(getUserId());
		commerceWishListImpl.setUserName(getUserName());
		commerceWishListImpl.setCreateDate(getCreateDate());
		commerceWishListImpl.setModifiedDate(getModifiedDate());
		commerceWishListImpl.setName(getName());
		commerceWishListImpl.setDefaultWishList(isDefaultWishList());

		commerceWishListImpl.resetOriginalValues();

		return commerceWishListImpl;
	}

	@Override
	public int compareTo(CommerceWishList commerceWishList) {
		int value = 0;

		value = getName().compareTo(commerceWishList.getName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CommerceWishList)) {
			return false;
		}

		CommerceWishList commerceWishList = (CommerceWishList)obj;

		long primaryKey = commerceWishList.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return ENTITY_CACHE_ENABLED;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return FINDER_CACHE_ENABLED;
	}

	@Override
	public void resetOriginalValues() {
		CommerceWishListModelImpl commerceWishListModelImpl = this;

		commerceWishListModelImpl._originalUuid =
			commerceWishListModelImpl._uuid;

		commerceWishListModelImpl._originalGroupId =
			commerceWishListModelImpl._groupId;

		commerceWishListModelImpl._setOriginalGroupId = false;

		commerceWishListModelImpl._originalCompanyId =
			commerceWishListModelImpl._companyId;

		commerceWishListModelImpl._setOriginalCompanyId = false;

		commerceWishListModelImpl._originalUserId =
			commerceWishListModelImpl._userId;

		commerceWishListModelImpl._setOriginalUserId = false;

		commerceWishListModelImpl._originalCreateDate =
			commerceWishListModelImpl._createDate;

		commerceWishListModelImpl._setModifiedDate = false;

		commerceWishListModelImpl._originalDefaultWishList =
			commerceWishListModelImpl._defaultWishList;

		commerceWishListModelImpl._setOriginalDefaultWishList = false;

		commerceWishListModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceWishList> toCacheModel() {
		CommerceWishListCacheModel commerceWishListCacheModel =
			new CommerceWishListCacheModel();

		commerceWishListCacheModel.uuid = getUuid();

		String uuid = commerceWishListCacheModel.uuid;

		if ((uuid != null) && (uuid.length() == 0)) {
			commerceWishListCacheModel.uuid = null;
		}

		commerceWishListCacheModel.commerceWishListId = getCommerceWishListId();

		commerceWishListCacheModel.groupId = getGroupId();

		commerceWishListCacheModel.companyId = getCompanyId();

		commerceWishListCacheModel.userId = getUserId();

		commerceWishListCacheModel.userName = getUserName();

		String userName = commerceWishListCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceWishListCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceWishListCacheModel.createDate = createDate.getTime();
		}
		else {
			commerceWishListCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceWishListCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			commerceWishListCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		commerceWishListCacheModel.name = getName();

		String name = commerceWishListCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			commerceWishListCacheModel.name = null;
		}

		commerceWishListCacheModel.defaultWishList = isDefaultWishList();

		return commerceWishListCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<CommerceWishList, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<CommerceWishList, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceWishList, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((CommerceWishList)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<CommerceWishList, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<CommerceWishList, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<CommerceWishList, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((CommerceWishList)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, CommerceWishList>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private String _uuid;
	private String _originalUuid;
	private long _commerceWishListId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _originalCompanyId;
	private boolean _setOriginalCompanyId;
	private long _userId;
	private long _originalUserId;
	private boolean _setOriginalUserId;
	private String _userName;
	private Date _createDate;
	private Date _originalCreateDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private String _name;
	private boolean _defaultWishList;
	private boolean _originalDefaultWishList;
	private boolean _setOriginalDefaultWishList;
	private long _columnBitmask;
	private CommerceWishList _escapedModel;

}