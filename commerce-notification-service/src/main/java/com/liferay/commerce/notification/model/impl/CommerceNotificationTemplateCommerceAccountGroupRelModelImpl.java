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

package com.liferay.commerce.notification.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.commerce.notification.model.CommerceNotificationTemplateCommerceAccountGroupRel;
import com.liferay.commerce.notification.model.CommerceNotificationTemplateCommerceAccountGroupRelModel;
import com.liferay.commerce.notification.model.CommerceNotificationTemplateCommerceAccountGroupRelSoap;
import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
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
 * The base model implementation for the CommerceNotificationTemplateCommerceAccountGroupRel service. Represents a row in the &quot;CNTemplateCAccountGroupRel&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface </code>CommerceNotificationTemplateCommerceAccountGroupRelModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link CommerceNotificationTemplateCommerceAccountGroupRelImpl}.
 * </p>
 *
 * @author Alessio Antonio Rendina
 * @see CommerceNotificationTemplateCommerceAccountGroupRelImpl
 * @generated
 */
@JSON(strict = true)
@ProviderType
public class CommerceNotificationTemplateCommerceAccountGroupRelModelImpl
	extends BaseModelImpl<CommerceNotificationTemplateCommerceAccountGroupRel>
	implements CommerceNotificationTemplateCommerceAccountGroupRelModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a commerce notification template commerce account group rel model instance should use the <code>CommerceNotificationTemplateCommerceAccountGroupRel</code> interface instead.
	 */
	public static final String TABLE_NAME = "CNTemplateCAccountGroupRel";

	public static final Object[][] TABLE_COLUMNS = {
		{"CNTemplateCAccountGroupRelId", Types.BIGINT},
		{"groupId", Types.BIGINT}, {"companyId", Types.BIGINT},
		{"userId", Types.BIGINT}, {"userName", Types.VARCHAR},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"commerceNotificationTemplateId", Types.BIGINT},
		{"commerceAccountGroupId", Types.BIGINT}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("CNTemplateCAccountGroupRelId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("userName", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("commerceNotificationTemplateId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("commerceAccountGroupId", Types.BIGINT);
	}

	public static final String TABLE_SQL_CREATE =
		"create table CNTemplateCAccountGroupRel (CNTemplateCAccountGroupRelId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,commerceNotificationTemplateId LONG,commerceAccountGroupId LONG)";

	public static final String TABLE_SQL_DROP =
		"drop table CNTemplateCAccountGroupRel";

	public static final String ORDER_BY_JPQL =
		" ORDER BY commerceNotificationTemplateCommerceAccountGroupRel.createDate DESC";

	public static final String ORDER_BY_SQL =
		" ORDER BY CNTemplateCAccountGroupRel.createDate DESC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.notification.service.util.ServiceProps.get(
			"value.object.entity.cache.enabled.com.liferay.commerce.notification.model.CommerceNotificationTemplateCommerceAccountGroupRel"),
		true);

	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.notification.service.util.ServiceProps.get(
			"value.object.finder.cache.enabled.com.liferay.commerce.notification.model.CommerceNotificationTemplateCommerceAccountGroupRel"),
		true);

	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(
		com.liferay.commerce.notification.service.util.ServiceProps.get(
			"value.object.column.bitmask.enabled.com.liferay.commerce.notification.model.CommerceNotificationTemplateCommerceAccountGroupRel"),
		true);

	public static final long COMMERCEACCOUNTGROUPID_COLUMN_BITMASK = 1L;

	public static final long COMMERCENOTIFICATIONTEMPLATEID_COLUMN_BITMASK = 2L;

	public static final long CREATEDATE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static CommerceNotificationTemplateCommerceAccountGroupRel toModel(
		CommerceNotificationTemplateCommerceAccountGroupRelSoap soapModel) {

		if (soapModel == null) {
			return null;
		}

		CommerceNotificationTemplateCommerceAccountGroupRel model =
			new CommerceNotificationTemplateCommerceAccountGroupRelImpl();

		model.setCommerceNotificationTemplateCommerceAccountGroupRelId(
			soapModel.
				getCommerceNotificationTemplateCommerceAccountGroupRelId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setCommerceNotificationTemplateId(
			soapModel.getCommerceNotificationTemplateId());
		model.setCommerceAccountGroupId(soapModel.getCommerceAccountGroupId());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<CommerceNotificationTemplateCommerceAccountGroupRel>
		toModels(
			CommerceNotificationTemplateCommerceAccountGroupRelSoap[]
				soapModels) {

		if (soapModels == null) {
			return null;
		}

		List<CommerceNotificationTemplateCommerceAccountGroupRel> models =
			new ArrayList<CommerceNotificationTemplateCommerceAccountGroupRel>(
				soapModels.length);

		for (CommerceNotificationTemplateCommerceAccountGroupRelSoap soapModel :
				soapModels) {

			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(
		com.liferay.commerce.notification.service.util.ServiceProps.get(
			"lock.expiration.time.com.liferay.commerce.notification.model.CommerceNotificationTemplateCommerceAccountGroupRel"));

	public CommerceNotificationTemplateCommerceAccountGroupRelModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _commerceNotificationTemplateCommerceAccountGroupRelId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setCommerceNotificationTemplateCommerceAccountGroupRelId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _commerceNotificationTemplateCommerceAccountGroupRelId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return CommerceNotificationTemplateCommerceAccountGroupRel.class;
	}

	@Override
	public String getModelClassName() {
		return CommerceNotificationTemplateCommerceAccountGroupRel.class.
			getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map
			<String,
			 Function
				 <CommerceNotificationTemplateCommerceAccountGroupRel, Object>>
					attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry
				<String,
				 Function
					 <CommerceNotificationTemplateCommerceAccountGroupRel,
					  Object>> entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function
				<CommerceNotificationTemplateCommerceAccountGroupRel, Object>
					attributeGetterFunction = entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply(
					(CommerceNotificationTemplateCommerceAccountGroupRel)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map
			<String,
			 BiConsumer
				 <CommerceNotificationTemplateCommerceAccountGroupRel, Object>>
					attributeSetterBiConsumers =
						getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer
				<CommerceNotificationTemplateCommerceAccountGroupRel, Object>
					attributeSetterBiConsumer = attributeSetterBiConsumers.get(
						attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(CommerceNotificationTemplateCommerceAccountGroupRel)this,
					entry.getValue());
			}
		}
	}

	public Map
		<String,
		 Function<CommerceNotificationTemplateCommerceAccountGroupRel, Object>>
			getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map
		<String,
		 BiConsumer
			 <CommerceNotificationTemplateCommerceAccountGroupRel, Object>>
				getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function
		<InvocationHandler, CommerceNotificationTemplateCommerceAccountGroupRel>
			_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			CommerceNotificationTemplateCommerceAccountGroupRel.class.
				getClassLoader(),
			CommerceNotificationTemplateCommerceAccountGroupRel.class,
			ModelWrapper.class);

		try {
			Constructor<CommerceNotificationTemplateCommerceAccountGroupRel>
				constructor =
					(Constructor
						<CommerceNotificationTemplateCommerceAccountGroupRel>)
							proxyClass.getConstructor(InvocationHandler.class);

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

	private static final Map
		<String,
		 Function<CommerceNotificationTemplateCommerceAccountGroupRel, Object>>
			_attributeGetterFunctions;
	private static final Map
		<String,
		 BiConsumer
			 <CommerceNotificationTemplateCommerceAccountGroupRel, Object>>
				_attributeSetterBiConsumers;

	static {
		Map
			<String,
			 Function
				 <CommerceNotificationTemplateCommerceAccountGroupRel, Object>>
					attributeGetterFunctions =
						new LinkedHashMap
							<String,
							 Function
								 <CommerceNotificationTemplateCommerceAccountGroupRel,
								  Object>>();
		Map
			<String,
			 BiConsumer<CommerceNotificationTemplateCommerceAccountGroupRel, ?>>
				attributeSetterBiConsumers =
					new LinkedHashMap
						<String,
						 BiConsumer
							 <CommerceNotificationTemplateCommerceAccountGroupRel,
							  ?>>();

		attributeGetterFunctions.put(
			"commerceNotificationTemplateCommerceAccountGroupRelId",
			new Function
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public Object apply(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel) {

					return commerceNotificationTemplateCommerceAccountGroupRel.
						getCommerceNotificationTemplateCommerceAccountGroupRelId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceNotificationTemplateCommerceAccountGroupRelId",
			new BiConsumer
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public void accept(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel,
					Object
						commerceNotificationTemplateCommerceAccountGroupRelId) {

					commerceNotificationTemplateCommerceAccountGroupRel.
						setCommerceNotificationTemplateCommerceAccountGroupRelId(
							(Long)
								commerceNotificationTemplateCommerceAccountGroupRelId);
				}

			});
		attributeGetterFunctions.put(
			"groupId",
			new Function
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public Object apply(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel) {

					return commerceNotificationTemplateCommerceAccountGroupRel.
						getGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"groupId",
			new BiConsumer
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public void accept(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel,
					Object groupId) {

					commerceNotificationTemplateCommerceAccountGroupRel.
						setGroupId((Long)groupId);
				}

			});
		attributeGetterFunctions.put(
			"companyId",
			new Function
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public Object apply(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel) {

					return commerceNotificationTemplateCommerceAccountGroupRel.
						getCompanyId();
				}

			});
		attributeSetterBiConsumers.put(
			"companyId",
			new BiConsumer
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public void accept(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel,
					Object companyId) {

					commerceNotificationTemplateCommerceAccountGroupRel.
						setCompanyId((Long)companyId);
				}

			});
		attributeGetterFunctions.put(
			"userId",
			new Function
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public Object apply(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel) {

					return commerceNotificationTemplateCommerceAccountGroupRel.
						getUserId();
				}

			});
		attributeSetterBiConsumers.put(
			"userId",
			new BiConsumer
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public void accept(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel,
					Object userId) {

					commerceNotificationTemplateCommerceAccountGroupRel.
						setUserId((Long)userId);
				}

			});
		attributeGetterFunctions.put(
			"userName",
			new Function
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public Object apply(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel) {

					return commerceNotificationTemplateCommerceAccountGroupRel.
						getUserName();
				}

			});
		attributeSetterBiConsumers.put(
			"userName",
			new BiConsumer
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public void accept(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel,
					Object userName) {

					commerceNotificationTemplateCommerceAccountGroupRel.
						setUserName((String)userName);
				}

			});
		attributeGetterFunctions.put(
			"createDate",
			new Function
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public Object apply(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel) {

					return commerceNotificationTemplateCommerceAccountGroupRel.
						getCreateDate();
				}

			});
		attributeSetterBiConsumers.put(
			"createDate",
			new BiConsumer
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public void accept(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel,
					Object createDate) {

					commerceNotificationTemplateCommerceAccountGroupRel.
						setCreateDate((Date)createDate);
				}

			});
		attributeGetterFunctions.put(
			"modifiedDate",
			new Function
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public Object apply(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel) {

					return commerceNotificationTemplateCommerceAccountGroupRel.
						getModifiedDate();
				}

			});
		attributeSetterBiConsumers.put(
			"modifiedDate",
			new BiConsumer
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public void accept(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel,
					Object modifiedDate) {

					commerceNotificationTemplateCommerceAccountGroupRel.
						setModifiedDate((Date)modifiedDate);
				}

			});
		attributeGetterFunctions.put(
			"commerceNotificationTemplateId",
			new Function
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public Object apply(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel) {

					return commerceNotificationTemplateCommerceAccountGroupRel.
						getCommerceNotificationTemplateId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceNotificationTemplateId",
			new BiConsumer
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public void accept(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel,
					Object commerceNotificationTemplateId) {

					commerceNotificationTemplateCommerceAccountGroupRel.
						setCommerceNotificationTemplateId(
							(Long)commerceNotificationTemplateId);
				}

			});
		attributeGetterFunctions.put(
			"commerceAccountGroupId",
			new Function
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public Object apply(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel) {

					return commerceNotificationTemplateCommerceAccountGroupRel.
						getCommerceAccountGroupId();
				}

			});
		attributeSetterBiConsumers.put(
			"commerceAccountGroupId",
			new BiConsumer
				<CommerceNotificationTemplateCommerceAccountGroupRel,
				 Object>() {

				@Override
				public void accept(
					CommerceNotificationTemplateCommerceAccountGroupRel
						commerceNotificationTemplateCommerceAccountGroupRel,
					Object commerceAccountGroupId) {

					commerceNotificationTemplateCommerceAccountGroupRel.
						setCommerceAccountGroupId((Long)commerceAccountGroupId);
				}

			});

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@JSON
	@Override
	public long getCommerceNotificationTemplateCommerceAccountGroupRelId() {
		return _commerceNotificationTemplateCommerceAccountGroupRelId;
	}

	@Override
	public void setCommerceNotificationTemplateCommerceAccountGroupRelId(
		long commerceNotificationTemplateCommerceAccountGroupRelId) {

		_commerceNotificationTemplateCommerceAccountGroupRelId =
			commerceNotificationTemplateCommerceAccountGroupRelId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
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
		_columnBitmask = -1L;

		_createDate = createDate;
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
	public long getCommerceNotificationTemplateId() {
		return _commerceNotificationTemplateId;
	}

	@Override
	public void setCommerceNotificationTemplateId(
		long commerceNotificationTemplateId) {

		_columnBitmask |= COMMERCENOTIFICATIONTEMPLATEID_COLUMN_BITMASK;

		if (!_setOriginalCommerceNotificationTemplateId) {
			_setOriginalCommerceNotificationTemplateId = true;

			_originalCommerceNotificationTemplateId =
				_commerceNotificationTemplateId;
		}

		_commerceNotificationTemplateId = commerceNotificationTemplateId;
	}

	public long getOriginalCommerceNotificationTemplateId() {
		return _originalCommerceNotificationTemplateId;
	}

	@JSON
	@Override
	public long getCommerceAccountGroupId() {
		return _commerceAccountGroupId;
	}

	@Override
	public void setCommerceAccountGroupId(long commerceAccountGroupId) {
		_columnBitmask |= COMMERCEACCOUNTGROUPID_COLUMN_BITMASK;

		if (!_setOriginalCommerceAccountGroupId) {
			_setOriginalCommerceAccountGroupId = true;

			_originalCommerceAccountGroupId = _commerceAccountGroupId;
		}

		_commerceAccountGroupId = commerceAccountGroupId;
	}

	public long getOriginalCommerceAccountGroupId() {
		return _originalCommerceAccountGroupId;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(),
			CommerceNotificationTemplateCommerceAccountGroupRel.class.getName(),
			getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public CommerceNotificationTemplateCommerceAccountGroupRel
		toEscapedModel() {

		if (_escapedModel == null) {
			Function
				<InvocationHandler,
				 CommerceNotificationTemplateCommerceAccountGroupRel>
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
		CommerceNotificationTemplateCommerceAccountGroupRelImpl
			commerceNotificationTemplateCommerceAccountGroupRelImpl =
				new CommerceNotificationTemplateCommerceAccountGroupRelImpl();

		commerceNotificationTemplateCommerceAccountGroupRelImpl.
			setCommerceNotificationTemplateCommerceAccountGroupRelId(
				getCommerceNotificationTemplateCommerceAccountGroupRelId());
		commerceNotificationTemplateCommerceAccountGroupRelImpl.setGroupId(
			getGroupId());
		commerceNotificationTemplateCommerceAccountGroupRelImpl.setCompanyId(
			getCompanyId());
		commerceNotificationTemplateCommerceAccountGroupRelImpl.setUserId(
			getUserId());
		commerceNotificationTemplateCommerceAccountGroupRelImpl.setUserName(
			getUserName());
		commerceNotificationTemplateCommerceAccountGroupRelImpl.setCreateDate(
			getCreateDate());
		commerceNotificationTemplateCommerceAccountGroupRelImpl.setModifiedDate(
			getModifiedDate());
		commerceNotificationTemplateCommerceAccountGroupRelImpl.
			setCommerceNotificationTemplateId(
				getCommerceNotificationTemplateId());
		commerceNotificationTemplateCommerceAccountGroupRelImpl.
			setCommerceAccountGroupId(getCommerceAccountGroupId());

		commerceNotificationTemplateCommerceAccountGroupRelImpl.
			resetOriginalValues();

		return commerceNotificationTemplateCommerceAccountGroupRelImpl;
	}

	@Override
	public int compareTo(
		CommerceNotificationTemplateCommerceAccountGroupRel
			commerceNotificationTemplateCommerceAccountGroupRel) {

		int value = 0;

		value = DateUtil.compareTo(
			getCreateDate(),
			commerceNotificationTemplateCommerceAccountGroupRel.
				getCreateDate());

		value = value * -1;

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

		if (!(obj instanceof
				CommerceNotificationTemplateCommerceAccountGroupRel)) {

			return false;
		}

		CommerceNotificationTemplateCommerceAccountGroupRel
			commerceNotificationTemplateCommerceAccountGroupRel =
				(CommerceNotificationTemplateCommerceAccountGroupRel)obj;

		long primaryKey =
			commerceNotificationTemplateCommerceAccountGroupRel.getPrimaryKey();

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
		CommerceNotificationTemplateCommerceAccountGroupRelModelImpl
			commerceNotificationTemplateCommerceAccountGroupRelModelImpl = this;

		commerceNotificationTemplateCommerceAccountGroupRelModelImpl.
			_setModifiedDate = false;

		commerceNotificationTemplateCommerceAccountGroupRelModelImpl.
			_originalCommerceNotificationTemplateId =
				commerceNotificationTemplateCommerceAccountGroupRelModelImpl.
					_commerceNotificationTemplateId;

		commerceNotificationTemplateCommerceAccountGroupRelModelImpl.
			_setOriginalCommerceNotificationTemplateId = false;

		commerceNotificationTemplateCommerceAccountGroupRelModelImpl.
			_originalCommerceAccountGroupId =
				commerceNotificationTemplateCommerceAccountGroupRelModelImpl.
					_commerceAccountGroupId;

		commerceNotificationTemplateCommerceAccountGroupRelModelImpl.
			_setOriginalCommerceAccountGroupId = false;

		commerceNotificationTemplateCommerceAccountGroupRelModelImpl.
			_columnBitmask = 0;
	}

	@Override
	public CacheModel<CommerceNotificationTemplateCommerceAccountGroupRel>
		toCacheModel() {

		CommerceNotificationTemplateCommerceAccountGroupRelCacheModel
			commerceNotificationTemplateCommerceAccountGroupRelCacheModel =
				new CommerceNotificationTemplateCommerceAccountGroupRelCacheModel();

		commerceNotificationTemplateCommerceAccountGroupRelCacheModel.
			commerceNotificationTemplateCommerceAccountGroupRelId =
				getCommerceNotificationTemplateCommerceAccountGroupRelId();

		commerceNotificationTemplateCommerceAccountGroupRelCacheModel.groupId =
			getGroupId();

		commerceNotificationTemplateCommerceAccountGroupRelCacheModel.
			companyId = getCompanyId();

		commerceNotificationTemplateCommerceAccountGroupRelCacheModel.userId =
			getUserId();

		commerceNotificationTemplateCommerceAccountGroupRelCacheModel.userName =
			getUserName();

		String userName =
			commerceNotificationTemplateCommerceAccountGroupRelCacheModel.
				userName;

		if ((userName != null) && (userName.length() == 0)) {
			commerceNotificationTemplateCommerceAccountGroupRelCacheModel.
				userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			commerceNotificationTemplateCommerceAccountGroupRelCacheModel.
				createDate = createDate.getTime();
		}
		else {
			commerceNotificationTemplateCommerceAccountGroupRelCacheModel.
				createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			commerceNotificationTemplateCommerceAccountGroupRelCacheModel.
				modifiedDate = modifiedDate.getTime();
		}
		else {
			commerceNotificationTemplateCommerceAccountGroupRelCacheModel.
				modifiedDate = Long.MIN_VALUE;
		}

		commerceNotificationTemplateCommerceAccountGroupRelCacheModel.
			commerceNotificationTemplateId =
				getCommerceNotificationTemplateId();

		commerceNotificationTemplateCommerceAccountGroupRelCacheModel.
			commerceAccountGroupId = getCommerceAccountGroupId();

		return commerceNotificationTemplateCommerceAccountGroupRelCacheModel;
	}

	@Override
	public String toString() {
		Map
			<String,
			 Function
				 <CommerceNotificationTemplateCommerceAccountGroupRel, Object>>
					attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry
				<String,
				 Function
					 <CommerceNotificationTemplateCommerceAccountGroupRel,
					  Object>> entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function
				<CommerceNotificationTemplateCommerceAccountGroupRel, Object>
					attributeGetterFunction = entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply(
					(CommerceNotificationTemplateCommerceAccountGroupRel)this));
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
		Map
			<String,
			 Function
				 <CommerceNotificationTemplateCommerceAccountGroupRel, Object>>
					attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry
				<String,
				 Function
					 <CommerceNotificationTemplateCommerceAccountGroupRel,
					  Object>> entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function
				<CommerceNotificationTemplateCommerceAccountGroupRel, Object>
					attributeGetterFunction = entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply(
					(CommerceNotificationTemplateCommerceAccountGroupRel)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler,
			 CommerceNotificationTemplateCommerceAccountGroupRel>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private long _commerceNotificationTemplateCommerceAccountGroupRelId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _commerceNotificationTemplateId;
	private long _originalCommerceNotificationTemplateId;
	private boolean _setOriginalCommerceNotificationTemplateId;
	private long _commerceAccountGroupId;
	private long _originalCommerceAccountGroupId;
	private boolean _setOriginalCommerceAccountGroupId;
	private long _columnBitmask;
	private CommerceNotificationTemplateCommerceAccountGroupRel _escapedModel;

}