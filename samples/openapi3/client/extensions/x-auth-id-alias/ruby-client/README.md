# x_auth_id_alias

XAuthIDAlias - the Ruby gem for the OpenAPI Extension x-auth-id-alias

This specification shows how to use x-auth-id-alias extension for API keys.

This SDK is automatically generated by the [OpenAPI Generator](https://openapi-generator.tech) project:

- API version: 1.0.0
- Package version: 1.0.0
- Generator version: 7.15.0-SNAPSHOT
- Build package: org.openapitools.codegen.languages.RubyClientCodegen

## Installation

### Build a gem

To build the Ruby code into a gem:

```shell
gem build x_auth_id_alias.gemspec
```

Then either install the gem locally:

```shell
gem install ./x_auth_id_alias-1.0.0.gem
```

(for development, run `gem install --dev ./x_auth_id_alias-1.0.0.gem` to install the development dependencies)

or publish the gem to a gem hosting service, e.g. [RubyGems](https://rubygems.org/).

Finally add this to the Gemfile:

    gem 'x_auth_id_alias', '~> 1.0.0'

### Install from Git

If the Ruby gem is hosted at a git repository: https://github.com/GIT_USER_ID/GIT_REPO_ID, then add the following in the Gemfile:

    gem 'x_auth_id_alias', :git => 'https://github.com/GIT_USER_ID/GIT_REPO_ID.git'

### Include the Ruby code directly

Include the Ruby code directly using `-I` as follows:

```shell
ruby -Ilib script.rb
```

## Getting Started

Please follow the [installation](#installation) procedure and then run the following code:

```ruby
# Load the gem
require 'x_auth_id_alias'

# Setup authorization
XAuthIDAlias.configure do |config|
  # Configure API key authorization: api_key
  config.api_key['X-Api-Key'] = 'YOUR API KEY'
  # Uncomment the following line to set a prefix for the API key, e.g. 'Bearer' (defaults to nil)
  # config.api_key_prefix['X-Api-Key'] = 'Bearer'

  # Configure API key authorization: api_key_query
  config.api_key['api_key'] = 'YOUR API KEY'
  # Uncomment the following line to set a prefix for the API key, e.g. 'Bearer' (defaults to nil)
  # config.api_key_prefix['api_key'] = 'Bearer'
end

api_instance = XAuthIDAlias::UsageApi.new

begin
  #Use any API key
  result = api_instance.any_key
  p result
rescue XAuthIDAlias::ApiError => e
  puts "Exception when calling UsageApi->any_key: #{e}"
end

```

## Documentation for API Endpoints

All URIs are relative to *http://petstore.swagger.io:80/v2*

Class | Method | HTTP request | Description
------------ | ------------- | ------------- | -------------
*XAuthIDAlias::UsageApi* | [**any_key**](docs/UsageApi.md#any_key) | **GET** /any | Use any API key
*XAuthIDAlias::UsageApi* | [**both_keys**](docs/UsageApi.md#both_keys) | **GET** /both | Use both API keys
*XAuthIDAlias::UsageApi* | [**key_in_header**](docs/UsageApi.md#key_in_header) | **GET** /header | Use API key in header
*XAuthIDAlias::UsageApi* | [**key_in_query**](docs/UsageApi.md#key_in_query) | **GET** /query | Use API key in query


## Documentation for Models



## Documentation for Authorization


Authentication schemes defined for the API:
### api_key


- **Type**: API key
- **API key parameter name**: X-Api-Key
- **Location**: HTTP header

### api_key_query


- **Type**: API key
- **API key parameter name**: api_key
- **Location**: URL query string

