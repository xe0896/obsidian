Liquid is where Jekyll starts to get more interesting. It is a templating language which has three main components:
- Objects
- Tags
- Filters
#### Objects
Objects tell Liquid to output predefined [variables](https://jekyllrb.com/docs/variables/) as content on a page. Use double curly braces for objects: `{{` and `}}`.

For example, `{{ page.title }}` displays the `page.title` variable.
#### Tags
Tags define the logic and control flow for templates. Use curly braces and percent signs for tags: `{%` and `%}`.

For example:
```jsx
{% if page.show_sidebar %}
  <div class="sidebar">
    sidebar content
  </div>
{% endif %}
```

This displays the sidebar if the value of the `show_sidebar` page variable is true.
#### Filters
Filters change the output of a Liquid object. They are used within an output and are separated by a `|`.

For example:

```jsx
{{ "hi" | capitalize }}
```

This displays `Hi` instead of `hi`.
